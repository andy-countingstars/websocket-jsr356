package com.example.jsr356.dto;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/24
 */
public class QrMessageDTO extends MessageDTO {

    private String qrCodeId;

    public String getQrCodeId() {
        return qrCodeId;
    }

    public void setQrCodeId(String qrCodeId) {
        this.qrCodeId = qrCodeId;
    }


//    public QrMessageDTO(QrMessageDTO qrMessageDTO, String qrCodeId) {
//        super(qrMessageDTO);
//        this.qrCodeId = qrCodeId;
//    }
//
//
//    public QrMessageDTO(QrMessageDTO qrMessageDTO) {
//        super(qrMessageDTO);
//    }
}
