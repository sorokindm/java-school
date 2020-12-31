package com.jschool.reha.config;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Custom MySQLEnumType to map mysql enum with jpa
 * @author Dmitry Sorokin
 */
public class MySQLEnumType extends org.hibernate.type.EnumType {
    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index,
                            SharedSessionContractImplementor session) throws HibernateException, SQLException {
        st.setObject(index,value!=null?((Enum)value).name():null, Types.OTHER);
    }
}
