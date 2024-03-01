package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import zlomek.Zlomek;

import static org.junit.jupiter.api.Assertions.*;

class ZlomekTest {
    Zlomek zlomek1;
    Zlomek zlomek2;

    @BeforeEach
    void setUp() {
        zlomek1 = new Zlomek(5,2);
        zlomek2 = new Zlomek(7,2);
    }

    @Test
    void getCitatel() {
        assertEquals(5, zlomek1.getCitatel());
        assertEquals(7, zlomek2.getCitatel());
    }

    @Test
    void setCitatel() {
        zlomek1.setCitatel(6);
        assertEquals(6, zlomek1.getCitatel());
        zlomek2.setCitatel(9);
        assertEquals(9, zlomek2.getCitatel());
    }

    @Test
    void getJmenovatel() {
        assertEquals(2, zlomek1.getJmenovatel());
    }

    @Test
    void setJmenovatel() {
        zlomek1.setJmenovatel(7);
        assertEquals(7, zlomek1.getJmenovatel());

        zlomek1.setJmenovatel(-4);
        assertEquals(-4, zlomek1.getJmenovatel());

        assertThrows(ArithmeticException.class, () -> zlomek1.setJmenovatel(0));

        try {
            zlomek1.setJmenovatel(10);
        } catch (ArithmeticException e) {
            fail();
        }
    }

    @Test
    void scitani() {
        //nejdrive zkontrolujeme kraceni
        Zlomek z = zlomek1.scitani(zlomek2);
        assertEquals(6,z.getCitatel());
        assertEquals(1,z.getJmenovatel());
    }

    @Test
    void odcitani() {
        Zlomek zl = zlomek1.odcitani(zlomek2);
        assertEquals(-1, zl.getCitatel());
        assertEquals(1, zl.getJmenovatel());
    }

    @Test
    void nasobeni() {
        Zlomek zlomek = zlomek1.nasobeni(zlomek2);
        assertEquals(35, zlomek.getCitatel());
        assertEquals(4, zlomek.getJmenovatel());
    }

    @Test
    void deleni() {
        Zlomek z = zlomek1.deleni(zlomek2);
        assertEquals(5,z.getCitatel()); //5/2
        assertEquals(7,z.getJmenovatel()); //7/2z
    }

    @Test
    void testToString() {
        assertEquals("5/2",zlomek1.toString());
        Zlomek zlomecek = new Zlomek(-2,3);
        assertEquals("-2/3",zlomecek.toString());
    }

    @Test
    void kraceni() {
        Zlomek zl = new Zlomek(12,2);
        zl.kraceni();
        assertEquals(6, zl.getCitatel());
        assertEquals(1, zl.getJmenovatel());

        Zlomek zl1 = new Zlomek(6,9);
        zl1.kraceni();
        assertEquals(2, zl1.getCitatel());
        assertEquals(3, zl1.getJmenovatel());

        Zlomek zl2 = new Zlomek(7,5);
        zl2.kraceni();
        assertEquals(7, zl2.getCitatel());
        assertEquals(5, zl2.getJmenovatel());

        Zlomek zl3 = new Zlomek(-7,-5);
        zl3.kraceni();
        assertEquals(7, zl3.getCitatel());
        assertEquals(5, zl3.getJmenovatel());
    }

    @Test
    void NSD() {
        assertEquals(1, Zlomek.NSD(5,7));
        assertEquals(2, Zlomek.NSD(4,2));
    }
}