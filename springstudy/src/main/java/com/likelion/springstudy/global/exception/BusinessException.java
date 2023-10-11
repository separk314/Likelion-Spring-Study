package com.likelion.springstudy.global.exception;

public class BusinessException extends RuntimeException{
    // Ex. not found exception이 발생했을 때, 404 에러 말고 커스텀 에러를 띄우고 싶을 때 사용


    public BusinessException(String message) {
        super(message);
    }
}
