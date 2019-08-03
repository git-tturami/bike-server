package com.gitturami.bikeserver.infra.leisure.repository;

import com.gitturami.bikeserver.infra.leisure.repository.body.LeisureBody;
import com.gitturami.bikeserver.infra.leisure.repository.header.LeisureHeader;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class LeisureResponse {
    @XmlElement(name = "header")
    public LeisureHeader header;
    @XmlElement(name = "body")
    public LeisureBody body;

    @Override
    public String toString() {
        return header.toString() + ", " + body.toString();
    }
}
