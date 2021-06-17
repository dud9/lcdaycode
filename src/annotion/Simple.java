package annotion;

import java.lang.annotation.*;

/**
 * @author liu yicheng
 * @date 2021/6/16 - 23:10
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Simple {
}
