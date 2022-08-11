// package com.xuegao.luanqibazao_1.guava.common.collect;
//
// import com.google.common.collect.Range;
// import com.google.common.primitives.Ints;
//
// public class RangeTest {
//     public static void main(String[] args) {
//         // create a range [a,b] = { x | a <= x <= b}
//         Range<Integer> range1 = Range.closed(0, 9);
//         System.out.print("[0,9] : ");
//         System.out.println("5 is present: " + range1.contains(5));
//         System.out.println("(1,2,3) is present: " + range1.containsAll(Ints.asList(1, 2, 3)));
//         System.out.println("Lower Bound: " + range1.lowerEndpoint());
//         System.out.println("Upper Bound: " + range1.upperEndpoint());
// //create a range (a,b) = { x | a < x < b}
//         Range<Integer> range2 = Range.open(0, 9);
//         System.out.print("(0,9) : ");
//         printRange(range2);
//
//         //create a range (a,b] = { x | a < x <= b}
//         Range<Integer> range3 = Range.openClosed(0, 9);
//         System.out.print("(0,9] : ");
//         printRange(range3);
//
//         //create a range [a,b) = { x | a <= x < b}
//         Range<Integer> range4 = Range.closedOpen(0, 9);
//         System.out.print("[0,9) : ");
//         printRange(range4);
//
//         // https://www.yiibai.com/guava/guava_range_class.html
//
//     }
// }
