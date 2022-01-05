package basics.accessmodifiertestprotected;

import basics.accessmodifiertest.AccessModifierclassA;

public class AccessModifierclassC extends AccessModifierclassA {

    public static void main(String ... args)
    {
        AccessModifierclassC  objc = new AccessModifierclassC();
        AccessModifierclassA objA = new AccessModifierclassA();

        AccessModifierclassA objNew = new AccessModifierclassC();

        //default access - not possible
        //private access - not possible

        //public access  - for both objects

        objA.publicBoolean = false;
        objc.publicBoolean = false;

        //protected access - possible only for this class ref (subclass)
        objc.protectedInt = 1;
        objc.method();




    }
}
