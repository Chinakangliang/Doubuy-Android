package com.tv.doubuy.utils;

import android.content.Context;
import android.util.Log;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.tv.doubuy.network.APIService;

import java.util.Random;

public class AliyunUtils {

    // 明文设置secret的方式建议只在测试时使用，更多鉴权模式请参考后面的`访问控制`章节
    static OSSCredentialProvider credentialProvider = null;
    static OSS oss = null;

    AliyunUploadCallback callbac;

    static {
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
        conf.setMaxConcurrentRequest(5); // 最大并发请求书，默认5个
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次

        credentialProvider = new OSSPlainTextAKSKCredentialProvider(APIService.ALIYUN_ACCESS_KEY_ID, APIService.ALIYUN_SECRET_ACCESS_KEY);
        oss = new OSSClient(DouBuyApplication.getInstance(), APIService.ALIYUN_OSS_HOST, credentialProvider, conf);


    }

    public String getObjectKey(String suffix, Context context) {

        DouBuyCache cache = new DouBuyCache(context);

        String userId = cache.getUserId();
        String fileName = System.currentTimeMillis() + "";
        fileName += new Random().nextInt(10000) + "";
        return String.format("%s/%s/img/%s.%s", "doubuy", userId, fileName, suffix);
    }

    public void upFile(String localFilePath, final Context context) {
        final String objectKey = getObjectKey(localFilePath.substring(localFilePath.lastIndexOf('.') + 1), context);

        PutObjectRequest put = new PutObjectRequest(APIService.ALIYUN_STORAGE_BUCKET_NAME, objectKey, localFilePath);
        // 异步上传时可以设置进度回调
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                Log.d("PutObject", "currentSize: " + currentSize + " totalSize: " + totalSize);
            }
        });

        OSSAsyncTask task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {

                if (callbac != null) {
                    callbac.onSuccess(objectKey);
                }

            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {


                // 请求异常
                if (clientExcepion != null) {
                    // 本地异常如网络异常等
                    clientExcepion.printStackTrace();
                }
                if (serviceException != null) {
                    // 服务异常
                    Log.e("ErrorCode", serviceException.getErrorCode());
                    Log.e("RequestId", serviceException.getRequestId());
                    Log.e("HostId", serviceException.getHostId());
                    Log.e("RawMessage", serviceException.getRawMessage());
                }
            }
        });
//        task.waitUntilFinished();
    }

    public interface AliyunUploadCallback {

        void onSuccess(String fileUrl);

        void onFailure(Exception e);
    }


    public void AliyunUploadCal(AliyunUploadCallback callback) {

        this.callbac = callback;
    }
}
