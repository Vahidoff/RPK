package userstore;

import org.junit.Test;
import tree.SimpleTree;
import tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTTest {
    @Test
    public void whenUserAddUpdateDeleteThenContains() {
        UserStoreT storeT = new UserStoreT();
        for (int i = 1; i < 21; i++) {
            storeT.add(new UserT(i, 100));
        }
        storeT.delete(storeT.getUT(3));
        storeT.getUT(4).setAmount(777);
        storeT.update(storeT.getUT(4));



//        assertThat(result, is(true));
    }

}
