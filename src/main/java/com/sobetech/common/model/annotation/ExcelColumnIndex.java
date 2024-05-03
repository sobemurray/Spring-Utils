package com.sobetech.common.model.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.sql.JDBCType;

/**
 * An annotation to map a class attribute to an Excel file column as well as the data type to be
 * expected in the spreadsheet
 *
 *
 * @author John Murray
 *
 * @since May 3, 2024
 *
 */
@Retention(RUNTIME)
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
public @interface ExcelColumnIndex
{
	int column();
	
	JDBCType type() default JDBCType.VARCHAR;
}
