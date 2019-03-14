package scau.huangyk.homeworkmanagementsystem.util;

import org.springframework.util.ClassUtils;

public class Constants {
    public static final String DEFAULT_PASSWORD="123456";
    public static final int DEFAULT=0;
    public static final int SUCCESS=1;
    public static final int FAIL=0;
    public static final long ROLE_ADMIN_KEY=1;
    public static final long ROLE_TEACHER_KEY=2;
    public static final long ROLE_STUDENT_KEY=3;
    public static final String RESOURCE_CODE="resource";
    public static final String HOMEWORK_CODE="homework";
    public static final String FILE_PATH= ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
}
