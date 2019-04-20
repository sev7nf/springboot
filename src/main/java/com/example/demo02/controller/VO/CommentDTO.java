package com.example.demo02.controller.VO;


public class CommentDTO {

    /**
     * 流程实例ID
     */
    private String processInsid;

    /**
     * 审批结论
     */
    private String comment;



    public String getProcessInsid() {
        return processInsid;
    }

    public void setProcessInsid(String processInsid) {
        this.processInsid = processInsid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
