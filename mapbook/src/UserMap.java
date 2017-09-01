import java.util.Calendar;
import java.util.Objects;

/**
 * UserMap.
 * @author Aleksundrr Vahheedofv (mailto:arbuzz333@hotmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserMap {
    /**
     * Name.
     */
    private String name;
    /**
     * children - number the children the UserMap has.
     */
    private int children;
    /**
     * birthday.
     */
    private Calendar birthday;
    /**
     * constructor.
     * @param name -
     * @param children -
     * @param birthday -
     */
    UserMap(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    /**
     * setBirthday.
     * @param calendar - birthday
     */
    public void setBirthday(Calendar calendar) {
        this.birthday = calendar;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        UserMap user = (UserMap) obj;
        return Objects.equals(this.name, user.name) && this.children == user.children
                && this.birthday == user.birthday;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + this.children;
        result = prime * result + ((this.birthday == null) ? 0 : this.birthday.hashCode());
        return result;
    }
}
