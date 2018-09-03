package com.ykj.java.common.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.aliyuncs.vod.model.v20170321.*;

import java.util.List;

// 每个API都需要引入对应的类，此处以调用GetVideoPlayAuth接口为例

/**
 * Created by daiweitao on 2018/6/30.
 */
public class Video {
    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) {
        //点播服务所在的Region，国内请填cn-shanghai，不要填写别的区域
        String regionId = "cn-shanghai";
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

    public static GetPlayInfoResponse getPlayInfo(DefaultAcsClient client, String video_id) throws Exception {
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        request.setVideoId(video_id);
        return client.getAcsResponse(request);
    }

    public static GetMezzanineInfoResponse getMezzanineInfo(DefaultAcsClient client,String video_id) throws Exception {
        GetMezzanineInfoRequest request = new GetMezzanineInfoRequest();
        request.setVideoId(video_id);
        //源片下载地址过期时间
        request.setAuthTimeout(3600L);
        return client.getAcsResponse(request);
    }

    public static GetVideoInfoResponse getVideoInfo(DefaultAcsClient client, String video_id) throws Exception {
        GetVideoInfoRequest request = new GetVideoInfoRequest();
        request.setVideoId(video_id);
        return client.getAcsResponse(request);
    }

    public static GetVideoPlayAuthResponse getVideoPlayAuth(DefaultAcsClient client) {
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId("5a39fb84086644208bf0a0f667ea4bcb");
        GetVideoPlayAuthResponse response = null;
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            throw new RuntimeException("GetVideoPlayAuthRequest Server failed");
        } catch (ClientException e) {
            throw new RuntimeException("GetVideoPlayAuthRequest Client failed");
        }
        response.getPlayAuth();              // 播放凭证
        response.getVideoMeta();             // 视频Meta信息
        return response;
    }

    /*获取上传地址和凭证函数*/
    public static CreateUploadVideoResponse createUploadVideo(DefaultAcsClient client,String Title,String Filename,String Descripition) throws Exception {
        CreateUploadVideoRequest request = new CreateUploadVideoRequest();
        request.setTitle(Title);
        request.setDescription(Descripition);
        request.setFileName(Filename);
        //request.setTags("标签1,标签2");
        //request.setCoverURL("/Users/daiweitao/IdeaProjects/demo/src/main/java/com/example/demo/video/model/shipin1.mp4");
        return client.getAcsResponse(request);
    }

    /*以下为调用示例*/
    public static void main(String[] argv) {
//        String video_id;
//        DefaultAcsClient client = initVodClient("LTAIXFimQNENaURr", "9NLvLlRlNzBDJmcB0bfWJOVl4rblNZ");
//        GetPlayInfoResponse response = new GetPlayInfoResponse();
//        try {
//            response = getPlayInfo(client);
//            List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
//            //播放地址
//            for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
//                System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
//            }
//            //Base信息
//            System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
//        } catch (YkjException e) {
//            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//        }
//        System.out.print("RequestId = " + response.getRequestId() + "\n");
//
//
//        GetMezzanineInfoResponse r = new GetMezzanineInfoResponse();
//        try {
//            r = getMezzanineInfo(client);
//            System.out.print("Mezzanine.VideoId = " + r.getMezzanine().getVideoId() + "\n");
//            System.out.print("Mezzanine.FileURL = " + r.getMezzanine().getFileURL() + "\n");
//            System.out.print("Mezzanine.Width = " + r.getMezzanine().getWidth() + "\n");
//            System.out.print("Mezzanine.Height = " + r.getMezzanine().getWidth() + "\n");
//            System.out.print("Mezzanine.Size = " + r.getMezzanine().getSize() + "\n");
//        } catch (YkjException e) {
//            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//        }
//        System.out.print("RequestId = " + r.getRequestId() + "\n");
//
//        GetVideoInfoResponse SB = new GetVideoInfoResponse();
//        try {
//            SB = getVideoInfo(client);
//            System.out.print("Title = " + SB.getVideo().getTitle() + "\n");
//            System.out.print("Description = " + SB.getVideo().getDescription() + "\n");
//        } catch (YkjException e) {
//            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//        }
//        System.out.print("RequestId = " + r.getRequestId() + "\n");
//
//        //DefaultAcsClient c = new DefaultAcsClient(profile);
//        GetVideoPlayAuthResponse resp = new GetVideoPlayAuthResponse();
//        try {
//            resp = getVideoPlayAuth(client);
//            //播放凭证
//            System.out.print("PlayAuth = " + resp.getPlayAuth() + "\n");
//            //VideoMeta信息
//            System.out.print("VideoMeta.Title = " + resp.getVideoMeta().getTitle() + "\n");
//        } catch (YkjException e) {
//            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//        }
//        System.out.print("RequestId = " + resp.getRequestId() + "\n");
//
//        CreateUploadVideoResponse respon = new CreateUploadVideoResponse();
//        try {
//            respon = createUploadVideo(client);
//            //video_id = respon.getVideoId();
//            System.out.print("VideoId = " + respon.getVideoId() + "\n");
//            System.out.print("UploadAddress = " + respon.getUploadAddress() + "\n");
//            System.out.print("UploadAuth = " + respon.getUploadAuth() + "\n");
//        } catch (YkjException e) {
//            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
//        }
//        System.out.print("RequestId = " + response.getRequestId() + "\n");
//
//        String endpoint = "sts.aliyuncs.com";
//        String roleArn = "acs:ram::1778028855519661:role/aliyunosstokengeneratorrole";
//        String roleSessionName = "session23";
//        String policy = "{\n" +
//                "    \"Version\": \"1\", \n" +
//                "    \"Statement\": [\n" +
//                "        {\n" +
//                "            \"Action\": [\n" +
//                "                \"oss:*\"\n" +
//                "            ], \n" +
//                "            \"Resource\": [\n" +
//                "                \"acs:oss:*:*:*\" \n" +
//                "            ], \n" +
//                "            \"Effect\": \"Allow\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
//        try {
//            // Init ACS Client
//            DefaultProfile.addEndpoint("", "", "Sts", endpoint);
//            final AssumeRoleRequest request = new AssumeRoleRequest();
//            request.setMethod(MethodType.POST);
//            request.setRoleArn(roleArn);
//            request.setRoleSessionName(roleSessionName);
//            request.setPolicy(policy); // Optional
//            final AssumeRoleResponse rb = client.getAcsResponse(request);
//            System.out.println("Expiration: " + rb.getCredentials().getExpiration());
//            System.out.println("Access Key Id: " + rb.getCredentials().getAccessKeyId());
//            System.out.println("Access Key Secret: " + rb.getCredentials().getAccessKeySecret());
//            System.out.println(rb.getCredentials().getSecurityToken());
//            System.out.println("RequestId: " + rb.getRequestId());
//        } catch (ClientException e) {
//            System.out.println("Failed：");
//            System.out.println("Error code: " + e.getErrCode());
//            System.out.println("Error message: " + e.getErrMsg());
//            System.out.println("RequestId: " + e.getRequestId());
//        }
    }

}