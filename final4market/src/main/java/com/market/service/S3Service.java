package com.market.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;

@Service
public class S3Service {

    private AmazonS3 s3Client;

    public S3Service() {
    	BasicAWSCredentials awsCreds = new BasicAWSCredentials("서비스키", "시크릿키");
        this.s3Client = AmazonS3ClientBuilder.standard()
        		.withRegion("ap-northeast-2")
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }
    //1시간짜리 임시 pre-signed URL 생성
    public URL generatePresignedUrl(String bucketName, String objectKey, HttpMethod httpMethod) {
        Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60; // 1시간
        expiration.setTime(expTimeMillis);

        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey)
                .withMethod(httpMethod)
                .withExpiration(expiration);

        return s3Client.generatePresignedUrl(generatePresignedUrlRequest);
    }

    public void deleteObject(String bucketName, String objectKey) {
        s3Client.deleteObject(bucketName, objectKey);
    }
}
