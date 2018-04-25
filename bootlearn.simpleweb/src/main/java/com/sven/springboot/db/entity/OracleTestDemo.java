package com.sven.springboot.db.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by 123 on 2016/8/13.
 */
@Entity
@Table(name = "oracle_test_demo")
public class OracleTestDemo implements Serializable {
    private static final long serialVersionUID = -4556437946343439160L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoInfo [id=" + id + ", name=" + name + "]";
    }
}
