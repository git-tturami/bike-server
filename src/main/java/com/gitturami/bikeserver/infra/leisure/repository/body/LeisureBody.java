package com.gitturami.bikeserver.infra.leisure.repository.body;

import com.gitturami.bikeserver.infra.leisure.repository.body.item.LeisureItem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class LeisureBody {
    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    public List<LeisureItem> items;

    @XmlElement(name = "numOfRows")
    int numOfRows;

    @XmlElement(name="totalCount")
    int totalCount;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("number of items : " + items.size() + "\n")
                .append("total count : " + totalCount + "\n")
                .append("num of rows : " + numOfRows + "\n\n");
        for (LeisureItem wrapper : items) {
            builder.append(wrapper.toString())
                    .append("\n\n");
        }
        return builder.toString();
    }
}
