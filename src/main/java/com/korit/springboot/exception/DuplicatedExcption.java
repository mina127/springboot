package com.korit.springboot.exception;

import com.korit.springboot.dto.ValidErrorRespDto;
import lombok.Getter;

import java.util.List;
@Getter
public class DuplicatedExcption extends RuntimeException {
    private ValidErrorRespDto validErrorRespDto;

    public DuplicatedExcption(String fieldName,String message) {
        super(message);

        this.validErrorRespDto = new ValidErrorRespDto(fieldName, message);
    }



}
