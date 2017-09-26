package userstore;

/**
 * UserT.
 * id, amount
 * @author Aleksundrr Vahheedofv (mailto:arbuzz333@hotmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserT {
    /**
     * id of UserT.
     */
    private int id;
    /**
     * the amount of User.
     */
    protected int amount;
    /**
     * constructor.
     * @param id -
     * @param amount -
     */
    public UserT(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }
    /**
     * @return - id.
     */
    public int getId() {
        return this.id;
    }
    /**
     * amount setup.
     * @param amount -
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
