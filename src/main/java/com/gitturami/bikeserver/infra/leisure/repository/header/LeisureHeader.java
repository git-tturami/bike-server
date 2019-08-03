package com.gitturami.bikeserver.infra.leisure.repository.header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class LeisureHeader {
    @XmlElement(name = "resultCode")
    public String resultCode;
    @XmlElement(name = "resultMsg")
    public String resultMsg;

    @Override
    public String toString() {
        return String.format("resultCode = %s, resultMsg = %s\n",
                resultCode, resultMsg);
    }
}
