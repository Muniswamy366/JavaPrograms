package com.arya.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

enum BlogPostType {
    NEWS,
    REVIEW,
    GUIDE
}

enum Tag {
    FOOD, ENTERTAINMENT, TRAVEL, UTILITY
}

@Data
public class GroupingBy {
    public static void main(String[] args) {
        BlogPost blogPost1 = new BlogPost();
        blogPost1.setAuthor("author1");
        blogPost1.setLikes(1);
        blogPost1.setType(BlogPostType.GUIDE);

        BlogPost blogPost2 = new BlogPost();
        blogPost2.setAuthor("author2");
        blogPost2.setLikes(2);
        blogPost2.setType(BlogPostType.NEWS);

        BlogPost blogPost3 = new BlogPost();
        blogPost3.setAuthor("author3");
        blogPost3.setLikes(3);
        blogPost3.setType(BlogPostType.REVIEW);

        BlogPost blogPost4 = new BlogPost();
        blogPost4.setAuthor("author4");
        blogPost4.setLikes(4);
        blogPost4.setType(BlogPostType.NEWS);

        BlogPost blogPost5 = new BlogPost();
        blogPost5.setAuthor("author3");
        blogPost5.setLikes(5);
        blogPost5.setType(BlogPostType.REVIEW);

        List<BlogPost> posts = Arrays.asList(blogPost1, blogPost2, blogPost3, blogPost4, blogPost5);

        // Case 1:
        // Simple Grouping by a Single Column
        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType));
        System.out.println("Case 1: " + postsPerType);

        // Case 2:
        // Grouping by with a Complex Map Key Type
        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(Collectors.groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
        System.out.println("Case 2: " + postsPerTypeAndAuthor);

        // Case 3:
        // Modifying the Returned Map Value Type
        Map<BlogPostType, Set<BlogPost>> postsPerTypeSet = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType, Collectors.toSet()));
        System.out.println("Case 3: " + postsPerTypeSet);

        // Case 4:
        // Grouping By Multiple Fields
        Map<String, Map<BlogPostType, List<BlogPost>>> multipleFields = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.groupingBy(BlogPost::getType)));
        System.out.println("Case 4: " + multipleFields);

        // Case 5:
        // Getting the Average from Grouped Results
        Map<BlogPostType, Double> averageLikesPerType = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType, Collectors.averagingInt(BlogPost::getLikes)));
        System.out.println("Case 5: " + averageLikesPerType);

        // Case 6:
        // Getting the Sum from Grouped Results
        Map<BlogPostType, Integer> likesPerType = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType, Collectors.summingInt(BlogPost::getLikes)));
        System.out.println("Case 6: " + likesPerType);

        // Case 7:
        // Getting the Maximum or Minimum from Grouped Results
        // Similarly, we can apply the minBy
        Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType, Collectors.maxBy(Comparator.comparingInt(BlogPost::getLikes))));
        System.out.println("Case 7: " + maxLikesPerPostType);

        // Case 8:
        // Getting the Count from Grouped Results
        Map<BlogPostType, Long> countPerType = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType, Collectors.counting()));
        System.out.println("Case 8: " + countPerType);

        // Case 9:
        // Modifying the Return Map Type
        EnumMap<BlogPostType, List<BlogPost>> modifiedMapType = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType,
                        () -> new EnumMap<>(BlogPostType.class), Collectors.toList()));
        System.out.println("Case 9: " + modifiedMapType);

        // Case 10:
        // Concurrent Grouping By Collector
        // To do a grouping operation concurrently, the stream needs to be parallel
        // function returns either a ConcurrentHashMap or a subclass of it.
        ConcurrentMap<BlogPostType, List<BlogPost>> concurrentGrouping = posts.parallelStream()
                .collect(Collectors.groupingByConcurrent(BlogPost::getType));
        System.out.println("Case 10: " + concurrentGrouping);

        // Case 11:
        // Getting the Count from Grouped Results
        List<String> fruits = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> itemsCount = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Case 11: " + itemsCount);

        // Case 12:
        // groupingBy with mapping
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
        Map<BigDecimal, Map<String, Long>> groupByPriceAndNameGetCount = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice, Collectors.groupingBy(Item::getName, Collectors.counting())));
        System.out.println("Case 12: " + groupByPriceAndNameGetCount);

        // Case 13:
        Map<BigDecimal, String> groupByPriceJoiningName = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, joining(","))));
        System.out.println("Case 13: " + groupByPriceJoiningName);

        // Case 14
        Map<BigDecimal, List<Item>> case14 = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice));
        System.out.println("Case 14: " + case14);

        // Case 15
        Map<BigDecimal, Set<BigDecimal>> case15 = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getPrice, Collectors.toSet())));
        System.out.println("Case 15: " + case15);

        // Case 16
        Map<Integer, List<Integer>> case16 = Stream.of(1, 2, 3, 5, 4).collect(Collectors.groupingBy(i -> i % 2, Collectors.toList()));
        System.out.println("Case 16: " + case16);

    }

}

@Data
class BlogPost {
    String title;
    String author;
    BlogPostType type;
    int likes;
}

@Data
@AllArgsConstructor
class Tuple {
    BlogPostType type;
    String author;
}

@Data
@AllArgsConstructor
class Item {
    private String name;
    private int qty;
    private BigDecimal price;
}

@Data
@AllArgsConstructor
class Expense {
    private final long amount;
    private final int year;
    private final List<Tag> tags;
}