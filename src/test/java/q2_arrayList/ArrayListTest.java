package q2_arrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Q2 ArrayList")
class ArrayListTest {

    private ArrayList empty;
    private ArrayList one;
    private ArrayList two;
    private ArrayList standard;

    void prepareEmpty() {
        empty = new ArrayList();
    }

    void prepareOne() {
        one = new ArrayList();
        one.add(6);
    }

    void prepareTwo() {
        two = new ArrayList();
        two.add(6);
        two.add(7);
    }

    void prepareStandard() {
        standard = new ArrayList();
        standard.add(6);
        standard.add(7);
        standard.add(3);
        standard.add(8);
        standard.add(4);
    }

    void check(String expected, ArrayList list) {
        assertEquals(expected, list.toString());
    }

    @DisplayName("Add and toString")
    @Nested
    class toStringAndAdd {

        @Test
        void case1() {
            prepareEmpty();
            check("[]", empty);
        }

        @Test
        void case2() {
            prepareOne();
            check("[6]", one);
        }

        @Test
        void case3() {
            prepareTwo();
            check("[6, 7]", two);
        }

        @Test
        void case4() {
            prepareStandard();
            check("[6, 7, 3, 8, 4]", standard);
        }
    }

    @Nested
    class get {

        @Test
        void emptyCase1() {
            prepareEmpty();
            assertEquals(-1, empty.get(0));
        }

        @Test
        void oneCase1() {
            prepareOne();
            assertEquals(6, one.get(0));
        }

        @Test
        void oneCase2() {
            prepareOne();
            assertEquals(-1, one.get(1));
        }

        @Test
        void standardCase1() {
            prepareStandard();
            assertEquals(6, standard.get(0));
        }

        @Test
        void standardCase2() {
            prepareStandard();
            assertEquals(7, standard.get(1));
        }

        @Test
        void standardCase3() {
            prepareStandard();
            assertEquals(4, standard.get(4));
        }

        @Test
        void standardCase4() {
            prepareStandard();
            assertEquals(-1, standard.get(5));
        }


    }

    @Nested
    class size {
        @Test
        void case1() {
            prepareEmpty();
            assertEquals(0, empty.size());
        }

        @Test
        void case2() {
            prepareOne();
            assertEquals(1, one.size());
        }

        @Test
        void case3() {
            prepareTwo();
            assertEquals(2, two.size());
        }

        @Test
        void case4() {
            prepareStandard();
            assertEquals(5, standard.size());
        }
    }

    @Nested
    class pop {

        @Test
        void case1() {
            prepareEmpty();
            empty.pop();
            check("[]", empty);
        }

        @Test
        void case2() {
            prepareOne();
            one.pop();
            check("[]", one);
        }

        @Test
        void case3() {
            prepareTwo();
            two.pop();
            check("[6]", two);
        }

        @Test
        void case4() {
            prepareStandard();
            standard.pop();
            check("[6, 7, 3, 8]", standard);
        }
    }

    @Nested
    class insert {

        @Nested
        class toEmpty {

            @Test
            void case1() {
                prepareEmpty();
                empty.insert(0, 1);
                check("[1]", empty);
            }

            @Test
            void case2() {
                prepareEmpty();
                empty.insert(1, 1);
                check("[]", empty);
            }
        }

        @Nested
        class toOne {

            @Test
            void case1() {
                prepareOne();
                one.insert(0, 1);
                check("[1, 6]", one);
            }

            @Test
            void case2() {
                prepareOne();
                one.insert(1, 1);
                check("[6, 1]", one);
            }

            @Test
            void case3() {
                prepareOne();
                one.insert(2, 1);
                check("[6]", one);
            }
        }

        @Nested
        class toTwo {

            @Test
            void case1() {
                prepareTwo();
                two.insert(0, 1);
                check("[1, 6, 7]", two);
            }

            @Test
            void case2() {
                prepareTwo();
                two.insert(1, 1);
                check("[6, 1, 7]", two);
            }

            @Test
            void case3() {
                prepareTwo();
                two.insert(2, 1);
                check("[6, 7, 1]", two);
            }

            @Test
            void case4() {
                prepareTwo();
                two.insert(3, 1);
                check("[6, 7]", two);
            }
        }
    }

    @Nested
    class remove {

        @Nested
        class fromEmpty {

            @Test
            void case1() {
                prepareEmpty();
                empty.remove(0);
                check("[]", empty);
            }
        }

        @Nested
        class fromOne {

            @Test
            void case1() {
                prepareOne();
                one.remove(0);
                check("[]", one);
            }

            @Test
            void case2() {
                prepareOne();
                one.remove(1);
                check("[6]", one);
            }
        }

        @Nested
        class fromTwo {

            @Test
            void case1() {
                prepareTwo();
                two.remove(0);
                check("[7]", two);
            }

            @Test
            void case2() {
                prepareTwo();
                two.remove(1);
                check("[6]", two);
            }

            @Test
            void case3() {
                prepareTwo();
                two.remove(2);
                check("[6, 7]", two);
            }

        }
    }

    @Nested
    @DisplayName("Integration Test")
    class integration {
        @Test
        void case1() {
            prepareOne();

            one.pop();
            one.add(2);
            check("[2]", one);
            assertEquals(1, one.size());

            one.add(3);
            one.add(4);
            one.pop();
            check("[2, 3]", one);
            assertEquals(2, one.size());
        }

        @Test
        void case2() {
            prepareOne();

            one.remove(0);
            one.insert(0, 1);
            check("[1]", one);
            assertEquals(1, one.size());

            one.insert(0, 2);
            one.insert(2, 3);
            check("[2, 1, 3]", one);
            assertEquals(3, one.size());

            one.remove(1);
            check("[2, 3]", one);
            assertEquals(2, one.size());
        }
    }
}