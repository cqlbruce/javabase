package com.sun.jvm;

import java.util.*;

public class HeadOOM {


    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<OOMObject>() ;

        while (true)
            list.add(new OOMObject()) ;

    }


    static class OOMObject{

    }

}
