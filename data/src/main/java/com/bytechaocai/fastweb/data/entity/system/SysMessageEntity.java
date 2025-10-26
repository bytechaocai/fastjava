
package com.bytechaocai.fastweb.data.entity.system;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

/**
 * 提示消息表 实体类。
 *
 * @author bytechaocai
 */
@Entity
@Table(name = "sys_message")
public class SysMessageEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 错误码。
     */
    @Id
    private String messageCode;
    /**
     * 提示文本。
     */
    @Column(name = "message_text", nullable = false)
    private String messageText;
    /**
     * 提示类型。
     */
    @Column(name = "message_type", nullable = false)
    private Short messageType;
    /**
     * 状态。
     */
    @Column(name = "message_status", nullable = false)
    private Short messageStatus;
    /**
     * 描述。
     */
    @Column(name = "message_description", nullable = false)
    private String messageDescription;

    public String getMessageCode() {
        return this.messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public Short getMessageType() {
        return this.messageType;
    }

    public void setMessageType(Short messageType) {
        this.messageType = messageType;
    }
    public Short getMessageStatus() {
        return this.messageStatus;
    }

    public void setMessageStatus(Short messageStatus) {
        this.messageStatus = messageStatus;
    }
    public String getMessageDescription() {
        return this.messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }
}

