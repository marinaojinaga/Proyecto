package logicaDeDatos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class MergeSortTest {
    Proyecto t1;
    Proyecto t2;
    Proyecto t3;
    Proyecto t4;
    Proyecto t5;
    Proyecto t6;
    ArrayList<Proyecto> tareas1;
    ArrayList<Proyecto> tareas2;
    @Before
    public void setUp(){
        tareas1 = new ArrayList<Proyecto>();
        t1 = new Proyecto(null,false,0,0);
        t2 = new Proyecto(null,false,0,0);
        t3 = new Proyecto(null,false,0,0);
        tareas2 = new ArrayList<Proyecto>();
        t4 = new Proyecto(null,false,0,0);
        t5 = new Proyecto(null,false,0,0);
        t6 = new Proyecto(null,false,0,0);
    }

    @After
    public void tearDown() {
        tareas1 = null;
        tareas2 =null;
        t1 = null;
        t2 = null;
        t3 = null;
        t4 = null;
        t5 = null;
        t6 = null;
    }

    @Test
    public void mergeSortAlfabeticoTest(){
        t1.setNombre("C");
        t2.setNombre("D");
        t3.setNombre("A");
        tareas1.add(t1);
        tareas1.add(t2);
        tareas1.add(t3);
        MergeSort<Proyecto> mergeSort = new MergeSort<Proyecto>();
        tareas2.add(t3);
        tareas2.add(t1);
        tareas2.add(t2);
        assertEquals(mergeSort.mergeSortAlfabetico(tareas1),tareas2);
    }
}
