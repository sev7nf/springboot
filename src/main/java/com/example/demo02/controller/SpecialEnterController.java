package com.example.demo02.controller;

import com.example.demo02.controller.VO.CommentDTO;
import com.example.demo02.controller.VO.EmpInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SpecialEnterController {
    private Logger logger = LoggerFactory.getLogger(SpecialEnterController.class);

    @RequestMapping(value = "/specialEnter",method = RequestMethod.POST)
    @ResponseBody
    public EmpInfoDTO start(EmpInfoDTO empInfoDTO) {
        // start insertAction

        // end
//        int empLevel = empInfoDTO.getPositionDTOList().get(0).getLevel();
        return empInfoDTO;
    }

    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    @ResponseBody
    public boolean addComment(boolean isApprove, CommentDTO commentDTO) {
        // start insertAction

        // end
        return isApprove;
    }

    @RequestMapping(value = "/specialEnterApprove",method = RequestMethod.POST)
    @ResponseBody
    public boolean specialEnterApprove(EmpInfoDTO empInfoDTO) {
        // start insertAction

        // end
        return !empInfoDTO.isTwiceEnter();
    }


    /**
     * 自动触发任务
     */
    @RequestMapping(value = "/releaseAuthorized",method = RequestMethod.POST)
    @ResponseBody
    public void releaseAuthorized() {
        //  finish the workFlow & tell authorized admin to release the authorize
    }
}
