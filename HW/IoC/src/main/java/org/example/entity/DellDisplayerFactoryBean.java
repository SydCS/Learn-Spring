package org.example.entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("dell")
public class DellDisplayerFactoryBean implements FactoryBean<DellDisplayer> {
    @Override
    public DellDisplayer getObject() throws Exception {
        return new DellDisplayer();
    }

    @Override
    public Class<?> getObjectType() {
        return DellDisplayer.class;
    }
}
