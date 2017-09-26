package userstore;

import org.junit.runner.notification.RunListener;

import java.util.TreeMap;
/**
 * Store.
 * the deposit for UserT
 * @author Aleksundrr Vahheedofv (mailto:arbuzz333@hotmail.com)
 * @version $Id$
 * @since 0.1
 */
@RunListener.ThreadSafe
public class UserStoreT extends Thread {
    int index = 0;

    private TreeMap<Integer, UserT> deposit = new TreeMap<>();
    /**
     * adding UserT.
     * @param user -
     */
    protected void add(UserT user) {
        synchronized (user) {
            deposit.put(user.getId(), user);
        }
    }

    void update(UserT user) {
        synchronized (user) {
            deposit.remove(user.getId());
            deposit.put(user.getId(), user);
        }
    }
    void delete(UserT user) {
        synchronized (user)  {
            deposit.remove(user.getId());
        }
    }

    UserT getUT(int id) {
        synchronized (deposit.get(id)) {
            return deposit.get(id);
        }
    }
    void transfer(int fromId, int toId, int amount) {
        UserT userFrom = getUT(fromId);
        UserT userTo = getUT(toId);
        getUT(fromId).setAmount(userFrom.amount - amount);
        getUT(toId).setAmount(userTo.amount + amount);

    }

}
