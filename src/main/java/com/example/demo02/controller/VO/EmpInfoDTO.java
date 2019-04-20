package com.example.demo02.controller.VO;

import lombok.Data;

import java.util.List;


@Data
public class EmpInfoDTO {
    private String 姓名;
    private Integer age;
    private String 身份证号;
    private boolean isTwiceEnter;
    private List<PositionDTO> positionDTOList;
    private List<SalaryDTO> salaryDTOList;
}
