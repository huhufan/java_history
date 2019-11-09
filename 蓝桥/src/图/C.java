package 图;

import java.util.HashSet;
import java.util.ServiceConfigurationError;
import java.util.Set;

public class C {
    static int f(Set hist, Set from,String goal) {
        if (from.contains(goal)) return 0;
        Set from2 = new HashSet();
        for (Object it : from) {
            //Set t = move(it.toString());
            //from2.addAll(t);
        }
        from2.removeAll(hist);
        if (from2.isEmpty()) return -1;

         hist.addAll(from2);
         int r = f(hist,from2,goal);
         if (r<0) return r;
         return r+1;


    }
}
