package uta.cse3310;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import uta.cse3310.InitialLobbyTest;
import uta.cse3310.Generator;
import uta.cse3310.UserEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class GeneratorTest  extends TestCase{

  public void testReadyPlayer(){
    ArrayList<String> words_used = new ArrayList<>(); 
    char[][] result_array = new char[50][50];
    ArrayList<String> words_expected = new ArrayList<>(Arrays.asList( 
          "accent",
          "abortion",
          "accessibility",
          "absorption",
          "acceptance",
          "abandoned",
          "access",
          "acceptance",
          "academic",
          "academic",
          "academics",
          "accepting",
          "above",
          "accepted",
          "abuse",
          "abstract",
          "accessed",
          "absolutely",
          "acceptable",
          "academic",
          "abuse",
          "accept",
          "academics",
          "acceptable",
          "accessed",
          "ability",
          "abraham",
          "academics",
          "able",
          "aberdeen",
          "abstracts",
          "about",
          "accent",
          "accepted",
          "absorption",
          "abortion",
          "accent",
          "about",
          "abuse",
          "absence",
          "accessibility",
          "ability",
          "abortion",
          "accessed",
          "accessed",
          "able",
          "about",
          "abilities",
          "abuse",
          "about",
          "acceptable",
          "absolute",
          "able",
          "absolute",
          "abroad",
          "accepting",
          "accessed",
          "accessed",
          "accepts",
          "accepting",
          "academics",
          "accent",
          "academy",
          "absolute",
          "absent",
          "access",
          "absolutely",
          "able",
          "access",
          "above",
          "accent",
          "abstracts",
          "academy",
          "aaron",
          "abraham",
          "able",
          "absence",
          "acceptance",
          "absence",
          "academic",
          "absolutely",
          "accessibility",
          "abilities",
          "academy",
          "accessed",
          "acceptable",
          "absorption",
          "aaron",
          "accessed",
          "about",
          "abandoned",
          "aaron",
          "accept",
          "accessibility",
          "accent",
          "accepting",
          "accessed",
          "absence",
          "academics",
          "abuse",
          "access",
          "academic",
          "absolutely",
          "abilities",
          "accessed",
          "accent",
          "absolute",
          "abstract",
          "acceptance",
          "aboriginal",
          "accessed",
          "absolute",
          "abortion",
          "accept",
          "abortion",
          "absorption",
          "absent",
          "absence",
          "aboriginal",
          "abroad",
          "ability",
          "abraham",
          "aaron",
          "academy",
          "accessed",
          "accepted",
          "abortion",
          "accepted",
          "absent",
          "access",
          "abandoned",
          "able",
          "abroad",
          "acceptance",
          "abstract",
          "accept",
          "abraham",
          "abraham",
          "aboriginal",
          "absent",
          "abraham",
          "acceptance",
          "accent",
          "above",
          "accessed",
          "accent",
          "abandoned",
          "abroad",
          "acceptance",
          "accepted",
          "above",
          "abroad",
          "aaron",
          "accent",
          "academics",
          "abroad",
          "accessibility",
          "abroad",
          "acceptance",
          "abstracts",
          "absolute",
          "abraham",
          "abstracts",
          "ability",
          "ability",
          "absolute",
          "accessed",
          "academics",
          "absent",
          "accessibility",
          "academics",
          "about",
          "absence",
          "abstracts",
          "aaron",
          "aberdeen",
          "accept",
          "abortion",
          "academics",
          "absorption",
          "able",
          "abroad",
          "accept",
          "absent",
          "absorption",
          "abstract",
          "accent",
          "absolutely",
          "able",
          "abstracts",
          "acceptance",
          "access",
          "academy",
          "absolute",
          "about",
          "absent",
          "abstracts",
          "access",
          "abstracts",
          "absolutely",
          "abandoned",
          "academics",
          "academics",
          "accent",
          "accepts",
          "abroad",
          "absolute",
          "ability",
          "absent",
          "accepted",
          "accepting",
          "abilities",
          "abilities",
          "able",
          "academy",
          "able",
          "abroad",
          "abroad",
          "above",
          "ability",
          "accent",
          "abuse",
          "abuse",
          "about",
          "above",
          "accent",
          "aaron",
          "able",
          "accept",
          "access"
            )); 
    ArrayList<String> word_list = new ArrayList<String>();
    word_list.add("aaron");
    word_list.add("abandoned");
    word_list.add("aberdeen");
    word_list.add("abilities");
    word_list.add("ability");
    word_list.add("able");
    word_list.add("aboriginal");
    word_list.add("abortion");
    word_list.add("about");
    word_list.add("above");
    word_list.add("abraham");
    word_list.add("abroad");
    word_list.add("absence");
    word_list.add("absent");
    word_list.add("absolute");
    word_list.add("absolutely");
    word_list.add("absorption");
    word_list.add("abstract");
    word_list.add("abstracts");
    word_list.add("abuse");
    word_list.add("academic");
    word_list.add("academics");
    word_list.add("academy");
    word_list.add("accent");
    word_list.add("accept");
    word_list.add("acceptable");
    word_list.add("acceptance");
    word_list.add("accepted");
    word_list.add("accepting");
    word_list.add("accepts");
    word_list.add("access");
    word_list.add("accessed");
    word_list.add("accessibility");

    char[][] expected = 
    { 
      {'k', 'x', 'a', 'a', 'b', 's', 't', 'r', 'a', 'c', 't', 's', 'v', 'a', 'c', 'a', 'd', 'e', 'm', 'y', 'k', 't', 'a', 'b', 'o', 'r', 't', 'i', 'o', 'n', 'y', 'a', 'b', 's', 't', 'r', 'a', 'c', 't', 's', 'a', 'c', 'c', 'e', 'n', 't', 'i', 'q', 'o', 's', },
      {'p', 'u', 'u', 'b', 'o', 'a', 'b', 'u', 's', 'e', 'o', 'v', 'a', 'b', 'l', 'e', 'n', 'a', 'a', 'r', 'o', 'n', 'd', 'd', 'w', 'z', 't', 'a', 'b', 'r', 'a', 'h', 'a', 'm', 'a', 'a', 'r', 'o', 'n', 'a', 'b', 's', 't', 'r', 'a', 'c', 't', 's', 'y', 'a', },
      {'a', 'a', 'a', 's', 's', 'w', 'y', 'a', 'b', 'i', 'l', 'i', 't', 'i', 'e', 's', 'k', 'a', 'c', 'c', 'e', 'p', 't', 'a', 'b', 'o', 'r', 'i', 'g', 'i', 'n', 'a', 'l', 'b', 'a', 'b', 'e', 'r', 'd', 'e', 'e', 'n', 'b', 'k', 'h', 'z', 'p', 'b', 'a', 'b', },
      {'a', 'c', 'c', 'c', 'l', 'o', 'e', 'a', 'b', 'u', 's', 'e', 'i', 'a', 'a', 'r', 'o', 'n', 'u', 't', 'a', 'b', 's', 'o', 'l', 'u', 't', 'e', 'b', 'a', 'b', 'r', 'o', 'a', 'd', 'a', 'b', 's', 'o', 'r', 'p', 't', 'i', 'o', 'n', 'g', 'w', 'g', 'c', 'l', },
      {'b', 'a', 'c', 'a', 'c', 'b', 'l', 'y', 'b', 'o', 'q', 'y', 'n', 'o', 'v', 'x', 'a', 'c', 'c', 'e', 's', 's', 'e', 'd', 'u', 'a', 'c', 'c', 'e', 'p', 't', 'e', 'd', 'a', 'b', 's', 'e', 'n', 'c', 'e', 'a', 'c', 'c', 'e', 'p', 't', 's', 'a', 'c', 'e', },
      {'o', 'c', 'a', 'e', 'd', 'e', 'a', 'u', 'z', 'z', 'a', 'l', 'y', 'x', 'g', 'z', 'a', 'b', 'o', 'u', 't', 'a', 'c', 'c', 'e', 's', 's', 'e', 'd', 'a', 'c', 'c', 'e', 'p', 't', 'a', 'n', 'c', 'e', 'j', 'a', 'b', 'r', 'o', 'a', 'd', 'o', 'x', 'e', 'e', },
      {'r', 'a', 'a', 'c', 'n', 'e', 'p', 'c', 't', 'f', 'a', 'c', 's', 'x', 'a', 't', 'o', 'w', 'x', 'v', 'm', 'r', 'i', 'h', 'p', 'q', 'u', 'a', 'b', 'r', 'a', 'h', 'a', 'm', 'y', 'y', 'i', 'a', 'c', 'c', 'e', 's', 's', 'w', 'z', 'h', 'q', 'v', 'n', 'o', },
      {'t', 'd', 'b', 'v', 'a', 't', 'm', 't', 'c', 'e', 'g', 'c', 'c', 'o', 'd', 'c', 'n', 'f', 'b', 'a', 'b', 's', 'o', 'l', 'u', 't', 'e', 'l', 'y', 'w', 'a', 'c', 'c', 'e', 's', 's', 'i', 'b', 'i', 'l', 'i', 't', 'y', 'm', 'd', 'l', 'b', 'k', 't', 'v', },
      {'i', 'e', 'u', 'd', 'p', 'd', 'h', 'i', 'a', 'e', 'l', 'a', 'c', 'e', 'n', 'a', 'c', 'w', 'a', 'p', 'a', 'b', 's', 't', 'r', 'a', 'c', 't', 'a', 'c', 'c', 'e', 'n', 't', 'a', 'c', 'c', 'e', 'p', 't', 'g', 'a', 'c', 'c', 'e', 'p', 't', 'i', 'n', 'g', },
      {'o', 'm', 's', 's', 'm', 'l', 'e', 'q', 'c', 'b', 's', 'y', 'b', 'e', 's', 'o', 'c', 'e', 'a', 'a', 'b', 'i', 'l', 'i', 't', 'i', 'e', 's', 'a', 'b', 'a', 'n', 'd', 'o', 'n', 'e', 'd', 'n', 'j', 'n', 'o', 'n', 'a', 'b', 'l', 'e', 'g', 'k', 'b', 'i', },
      {'n', 'i', 'e', 'l', 'z', 't', 's', 'm', 'm', 'a', 'l', 's', 'b', 's', 'p', 's', 'h', 'c', 'p', 'b', 'l', 'u', 'd', 'm', 'a', 'c', 'a', 'd', 'e', 'm', 'y', 'k', 'q', 'd', 'a', 'b', 'o', 'r', 't', 'i', 'o', 'n', 'a', 'b', 'r', 'o', 'a', 'd', 'y', 'q', },
      {'n', 'c', 'y', 'a', 'b', 'o', 'u', 't', 'i', 'e', 'b', 'e', 'e', 'q', 'o', 't', 'e', 'e', 'e', 't', 's', 'n', 'l', 'b', 'a', 'c', 'c', 'e', 's', 's', 'e', 'd', 'v', 'z', 'a', 'c', 'a', 'd', 'e', 'm', 'i', 'c', 's', 'g', 'c', 'u', 'd', 'b', 'l', 'u', },
      {'c', 'w', 'a', 'c', 'c', 'e', 'p', 't', 'm', 'c', 'u', 'l', 't', 'd', 'a', 'l', 's', 'd', 'u', 's', 'a', 'e', 'x', 'a', 'b', 'r', 'o', 'a', 'd', 'u', 'a', 'b', 'r', 'o', 'a', 'd', 'a', 'c', 'c', 'e', 'p', 't', 'a', 'n', 'c', 'e', 'h', 'n', 'v', 'd', },
      {'g', 'a', 'c', 'a', 'd', 'e', 'm', 'i', 'c', 's', 'z', 'l', 'e', 'b', 'a', 'b', 'u', 'p', 'a', 'l', 's', 'n', 'n', 'm', 'b', 'a', 'm', 'a', 'b', 'o', 'r', 'i', 'g', 'i', 'n', 'a', 'l', 'h', 'j', 'k', 'd', 'c', 'g', 'd', 'e', 'a', 'b', 'o', 'u', 't', },
      {'a', 'c', 'c', 'e', 's', 's', 'i', 'b', 'i', 'l', 'i', 't', 'y', 'h', 'a', 'c', 's', 't', 'a', 'h', 'a', 'e', 'c', 'c', 'z', 'n', 'a', 'b', 's', 't', 'r', 'a', 'c', 't', 'b', 'w', 'y', 'w', 'a', 'b', 's', 'e', 'n', 't', 'z', 'o', 'x', 'r', 'm', 'c', },
      {'h', 'a', 'a', 'c', 'a', 'd', 'e', 'm', 'i', 'c', 's', 'w', 'g', 'o', 's', 'b', 'a', 'e', 'e', 'c', 's', 'c', 'd', 'e', 'e', 'a', 'b', 's', 'e', 'n', 't', 'x', 'a', 'c', 'a', 'd', 'e', 'm', 'i', 'c', 's', 'n', 'b', 'o', 'n', 'a', 'o', 'v', 'j', 'f', },
      {'a', 'k', 'c', 'd', 'y', 'u', 'a', 'a', 'b', 'o', 'u', 't', 'c', 'u', 'x', 'o', 's', 'd', 'n', 'a', 'a', 'a', 'c', 'w', 'a', 'c', 'c', 'e', 'p', 't', 'e', 'd', 'u', 'a', 'b', 's', 't', 'r', 'a', 'c', 't', 's', 'a', 'b', 'r', 'o', 'a', 'd', 'w', 'i', },
      {'b', 'a', 'a', 'c', 'a', 'u', 'f', 'y', 'd', 'a', 'b', 's', 'o', 'l', 'u', 't', 'e', 'o', 'e', 'c', 'c', 'd', 'x', 'e', 'j', 'a', 'c', 'c', 'e', 's', 's', 'u', 'q', 'x', 'a', 'b', 's', 'o', 'r', 'p', 't', 'i', 'o', 'n', 'e', 'w', 'l', 'a', 'h', 'i', },
      {'s', 's', 'b', 'c', 'e', 'm', 'a', 'c', 'c', 'e', 's', 's', 'e', 'd', 'a', 'q', 's', 'x', 'l', 'm', 'e', 'c', 'e', 'l', 'p', 'g', 'j', 'c', 't', 'a', 'c', 'c', 'e', 'p', 't', 'e', 'd', 'z', 'x', 'a', 'b', 's', 'o', 'l', 'u', 't', 'e', 'l', 'y', 'z', },
      {'o', 'k', 'f', 'o', 'c', 'p', 'w', 'b', 't', 'q', 'a', 'v', 'p', 'u', 'b', 'c', 'a', 'h', 'a', 'u', 'i', 'a', 'e', 'm', 'y', 't', 's', 'h', 'a', 'v', 'd', 's', 'a', 'b', 's', 'e', 'n', 't', 'a', 'b', 's', 't', 'r', 'a', 'c', 't', 's', 'n', 'z', 'g', },
      {'r', 'a', 'f', 'a', 'v', 'e', 't', 'k', 'x', 'e', 'a', 'c', 'a', 'r', 'q', 't', 'c', 'b', 'f', 'b', 't', 'c', 'b', 's', 'i', 'a', 'a', 'a', 'b', 's', 'e', 'n', 't', 's', 'a', 'a', 'b', 's', 't', 'r', 'a', 'c', 't', 'y', 'n', 'e', 'n', 'y', 'v', 'g', },
      {'p', 'c', 'a', 'a', 'c', 'e', 'p', 'i', 'a', 's', 'c', 'c', 'c', 'c', 'y', 'a', 'n', 'e', 'a', 'o', 'u', 'e', 'b', 's', 's', 'c', 'b', 'n', 'i', 'f', 'x', 'r', 't', 'g', 'w', 'b', 'q', 'a', 'c', 'a', 'd', 'e', 'm', 'y', 'x', 'g', 't', 's', 'g', 'j', },
      {'t', 'c', 'c', 'c', 'q', 'c', 'w', 't', 'n', 'c', 'w', 'a', 'a', 'e', 'c', 'j', 'c', 'a', 's', 'n', 'f', 's', 'l', 'z', 'o', 'e', 's', 'a', 'c', 'a', 'p', 'a', 's', 'a', 'a', 'a', 'l', 'k', 'z', 'c', 't', 'u', 'w', 'p', 'f', 'h', 'b', 'n', 'u', 'p', },
      {'i', 'e', 'c', 'c', 'h', 'a', 'e', 'e', 'a', 'g', 'c', 'a', 'b', 'd', 'p', 'e', 'm', 'c', 'c', 's', 'd', 'k', 'e', 'y', 'b', 'l', 'd', 'a', 'n', 'e', 'b', 'a', 'b', 'f', 'd', 'b', 'c', 'e', 'z', 'a', 'a', 'b', 's', 'o', 'l', 'u', 't', 'e', 'j', 'z', },
      {'o', 'p', 'e', 'e', 'e', 'g', 'k', 'n', 'g', 'b', 'g', 'e', 'c', 's', 'e', 't', 's', 'a', 'e', 'c', 'i', 'o', 'a', 'a', 'b', 'a', 'u', 'k', 'b', 'd', 'd', 'o', 'b', 'i', 'k', 'a', 'r', 'c', 'g', 'a', 'b', 'a', 'c', 'a', 'b', 'i', 'l', 'i', 't', 'y', },
      {'n', 't', 's', 'p', 'v', 't', 'j', 'm', 't', 'k', 'l', 'a', 'p', 'c', 'e', 'm', 'i', 's', 'c', 'p', 'e', 'b', 'n', 'b', 'b', 'y', 'b', 't', 'h', 'r', 'o', 'a', 'v', 'i', 'l', 'g', 'y', 'o', 'e', 'j', 'c', 'a', 'b', 'a', 'b', 'v', 'e', 'z', 'a', 'a', },
      {'x', 'e', 's', 't', 'p', 'a', 'i', 'l', 'c', 'x', 'q', 'e', 'b', 't', 'e', 'n', 'i', 'n', 'c', 'c', 't', 's', 'i', 'e', 's', 'i', 'e', 'l', 'e', 'a', 'a', 'n', 'b', 'e', 'l', 'i', 'y', 'l', 'a', 'n', 'a', 'a', 'n', 'i', 'c', 'w', 'p', 'k', 'a', 'c', },
      {'u', 'd', 'e', 'e', 'g', 'a', 'b', 's', 'e', 'n', 'c', 'e', 'a', 's', 'a', 's', 't', 'c', 'g', 'i', 'e', 'a', 's', 'l', 'd', 'o', 'l', 'r', 'e', 'a', 'b', 'h', 'e', 's', 'a', 'i', 't', 'f', 'a', 'd', 't', 'b', 'd', 'd', 'l', 'c', 'x', 'l', 'r', 'c', },
      {'s', 'f', 'd', 'd', 'a', 'c', 'c', 'e', 'n', 't', 'w', 'c', 'z', 'b', 'o', 'b', 's', 'z', 's', 'm', 'z', 'n', 'b', 'i', 'i', 'b', 'r', 'i', 'd', 'a', 'a', 'r', 'a', 'd', 'o', 'c', 't', 'y', 'j', 'd', 'f', 'a', 'i', 'e', 'o', 'i', 'e', 'r', 'o', 'e', },
      {'o', 'v', 'a', 'b', 'i', 'l', 'i', 't', 'y', 'f', 'u', 'w', 'c', 'u', 'o', 'l', 'l', 't', 'v', 'x', 'b', 'x', 't', 'l', 'b', 't', 'p', 'p', 't', 'o', 'c', 'r', 'o', 'm', 'n', 'l', 'c', 'y', 'm', 'c', 'a', 'm', 'b', 'l', 'm', 'n', 't', 'n', 'n', 'p', },
      {'e', 's', 'y', 'a', 'b', 's', 'o', 'r', 'p', 't', 'i', 'o', 'n', 'v', 'b', 'v', 'u', 'e', 'p', 'v', 's', 'n', 'e', 'a', 'e', 'i', 'y', 'r', 't', 'y', 'a', 'c', 'o', 'a', 'k', 'c', 'u', 'e', 't', 'd', 'b', 'p', 'z', 'i', 'i', 'i', 'e', 'i', 't', 't', },
      {'g', 'e', 'a', 'b', 'r', 'a', 'h', 'a', 'm', 'r', 'a', 'c', 'c', 'e', 'n', 't', 'e', 't', 'a', 'c', 'c', 'e', 's', 's', 'b', 'm', 'l', 'x', 'o', 'i', 'e', 'c', 'e', 'n', 'd', 'a', 'a', 't', 'p', 'o', 's', 'b', 'i', 'w', 'l', 't', 'c', 'd', 'e', 'l', },
      {'l', 'l', 'i', 's', 'a', 'a', 'c', 'c', 'e', 's', 's', 'i', 'b', 'i', 'l', 'i', 't', 'y', 'e', 'b', 'y', 's', 'a', 'k', 'h', 'r', 't', 'i', 'p', 'a', 'o', 'o', 'c', 'n', 'h', 'a', 'b', 'a', 'e', 't', 'e', 'f', 'r', 'i', 'a', 'i', 'y', 's', 'v', 's', },
      {'a', 'r', 'k', 'm', 'h', 'b', 'j', 'd', 'a', 'b', 's', 'o', 'l', 'u', 't', 'e', 'r', 'a', 'w', 'l', 'k', 'w', 'u', 'b', 'a', 'a', 'a', 'a', 't', 'a', 'c', 'n', 'y', 'e', 't', 'a', 'b', 's', 'b', 'd', 'n', 'a', 'x', 'c', 'u', 'b', 't', 'f', 'u', 'y', },
      {'a', 'c', 'u', 'p', 'y', 'l', 'o', 'u', 'n', 'a', 'z', 'r', 'a', 'c', 'c', 'e', 'n', 't', 'm', 'w', 'y', 'y', 'u', 'g', 's', 'b', 'b', 'h', 'c', 'y', 'b', 'a', 'a', 'd', 'p', 'a', 'k', 'l', 'o', 's', 't', 'a', 'b', 'j', 'p', 'q', 'u', 'i', 'l', 'd', },
      {'b', 'v', 'c', 'a', 'o', 'c', 'a', 'u', 'o', 'x', 'b', 's', 'a', 'h', 'b', 'a', 'b', 's', 'o', 'r', 'p', 't', 'i', 'o', 'n', 'e', 'o', 'r', 'a', 'c', 'a', 'r', 'd', 'c', 'a', 't', 'b', 'h', 'e', 'l', 'o', 'v', 'c', 'l', 'a', 'y', 'd', 's', 'e', 'k', },
      {'a', 'x', 'a', 'e', 'b', 'a', 'a', 'b', 't', 'n', 'j', 'r', 'v', 'b', 'a', 'b', 'i', 'l', 'i', 't', 'i', 'e', 's', 'w', 'x', 't', 'n', 'r', 'o', 'm', 'e', 'b', 'o', 'e', 'c', 'b', 'a', 's', 'a', 'p', 'u', 'l', 'f', 'a', 'e', 'a', 'x', 'j', 'e', 's', },
      {'n', 'c', 'b', 'c', 'p', 'o', 'b', 'b', 'l', 'a', 'x', 'h', 'o', 'r', 's', 'a', 'e', 'g', 'a', 'c', 'a', 'd', 'e', 'm', 'i', 'c', 'r', 't', 't', 'a', 't', 'p', 's', 'a', 'm', 'e', 's', 'n', 't', 'c', 'a', 't', 'u', 'c', 'd', 'p', 'b', 'w', 'k', 's', },
      {'d', 'a', 'g', 'w', 'a', 't', 'r', 'i', 'o', 'e', 'c', 'l', 'e', 'a', 's', 't', 'a', 'a', 'c', 'c', 'e', 'p', 't', 'i', 'n', 'g', 'q', 'h', 'i', 'i', 'd', 'a', 't', 't', 'd', 'i', 's', 'e', 'c', 'r', 'c', 'c', 'e', 't', 'a', 'e', 'r', 'o', 'q', 'l', },
      {'o', 'h', 'b', 'v', 'a', 'd', 'a', 't', 'l', 'u', 'a', 'c', 's', 'x', 'd', 'l', 'r', 'r', 'b', 'a', 'a', 'u', 'a', 'b', 's', 'e', 'n', 'c', 'e', 'd', 'o', 'e', 'e', 'a', 'r', 'b', 'c', 's', 'n', 'e', 'a', 'e', 'c', 'l', 'e', 'b', 'm', 'z', 'v', 'b', },
      {'n', 'z', 'm', 'u', 'd', 's', 'e', 'n', 'i', 'i', 't', 'c', 'e', 'a', 'h', 'n', 'i', 'a', 'o', 'd', 'c', 'a', 'b', 'o', 'r', 't', 'i', 'o', 'n', 'j', 'g', 'n', 'a', 'p', 'n', 'a', 'j', 's', 'i', 't', 'm', 'c', 's', 'e', 'y', 's', 'u', 'y', 't', 'e', },
      {'e', 'v', 'u', 'o', 's', 'e', 'h', 'm', 'c', 'o', 't', 'c', 'b', 'p', 'b', 'l', 'z', 'a', 'c', 'n', 'i', 'c', 'c', 'b', 'p', 'n', 'a', 'c', 'c', 'e', 'p', 't', 'r', 'g', 'h', 'c', 'c', 'e', 'd', 'b', 'y', 't', 't', 's', 'p', 'x', 's', 's', 's', 'a', },
      {'d', 'b', 'o', 'c', 'b', 'e', 'd', 'i', 'i', 'e', 'n', 'y', 'r', 'i', 't', 'r', 't', 'k', 'c', 't', 't', 'a', 'e', 'a', 's', 'u', 't', 'a', 'c', 'c', 'e', 'n', 't', 'y', 'f', 'g', 'e', 't', 't', 'j', 'i', 'x', 'i', 's', 'p', 't', 'r', 'c', 'e', 'c', },
      {'m', 'a', 'b', 's', 't', 'r', 'a', 'c', 't', 'c', 'e', 'n', 'h', 'g', 'x', 'i', 'a', 'y', 'z', 'c', 's', 'l', 'c', 'n', 'a', 'l', 'c', 'u', 'c', 'l', 'a', 'b', 's', 'o', 'l', 'u', 't', 'e', 's', 'a', 'j', 'l', 'g', 'h', 'x', 'a', 'e', 'l', 'y', 'c', },
      {'p', 'c', 'a', 'b', 'l', 'e', 'y', 'g', 'k', 'u', 's', 'x', 'c', 'o', 'k', 'x', 'n', 'h', 'o', 'm', 'e', 'q', 'j', 'c', 't', 'r', 'c', 'a', 'b', 'o', 'v', 'e', 'a', 'c', 'a', 'd', 'e', 'm', 'i', 'c', 's', 'g', 'i', 'a', 'i', 'z', 'n', 'd', 'f', 'e', },
      {'a', 'c', 'c', 'e', 's', 's', 'c', 'x', 'g', 'a', 'c', 'c', 'e', 's', 's', 'e', 'd', 'g', 'a', 'u', 'b', 's', 'm', 'a', 'e', 'b', 'o', 'y', 'p', 'l', 's', 'a', 'a', 'b', 'o', 'u', 't', 't', 'e', 'i', 'v', 'd', 'r', 't', 'f', 'k', 'y', 's', 'g', 's', },
      {'c', 'a', 'c', 'c', 'e', 's', 's', 'e', 'd', 'x', 'a', 'c', 'a', 'd', 'e', 'm', 'y', 'b', 'u', 'm', 'n', 's', 's', 'm', 'g', 'p', 'x', 'n', 'g', 'p', 'a', 'b', 'r', 'a', 'h', 'a', 'm', 'o', 'k', 's', 'n', 'l', 'c', 'b', 'y', 'g', 'n', 'g', 'y', 's', },
      {'y', 'd', 'i', 'c', 'y', 'a', 'b', 'o', 'r', 't', 'i', 'o', 'n', 'o', 'a', 'c', 'a', 'd', 'e', 'm', 'y', 'z', 'h', 'e', 'z', 'i', 't', 'a', 'c', 'c', 'e', 's', 's', 'e', 'd', 'k', 'v', 'b', 'z', 'a', 'c', 'a', 'd', 'e', 'm', 'i', 'c', 's', 'v', 'w', },
      {'p', 'm', 'a', 'b', 'e', 'r', 'd', 'e', 'e', 'n', 'o', 'g', 'x', 'a', 'b', 'l', 'e', 'o', 'o', 'w', 's', 'm', 'a', 'h', 'd', 'a', 'c', 'c', 'e', 'p', 't', 'a', 'n', 'c', 'e', 'v', 'x', 'a', 'b', 'o', 'u', 't', 'a', 'b', 'o', 'v', 'e', 'v', 'c', 'f', },
      {'a', 'c', 'c', 'e', 'p', 't', 'a', 'n', 'c', 'e', 'j', 'c', 'k', 'a', 'b', 's', 'e', 'n', 'c', 'e', 'a', 'b', 'o', 'r', 'i', 'g', 'i', 'n', 'a', 'l', 'b', 'a', 'c', 'c', 'e', 's', 's', 'e', 'd', 't', 'u', 'b', 'x', 's', 'w', 'y', 'k', 'm', 'g', 'x', }
    };

    result_array = Generator.createGrid(word_list, (long) 1234);
    words_used = Generator.getWords(word_list, (long) 1234);
    assertArrayEquals(expected, result_array);
    assertEquals(words_used, words_expected);
  }
  public static void printGrid(char[][] my_array)
  {
    for ( int y = 0; y < my_array.length; y ++)
    {
      System.out.format("{");
      for ( int x = 0; x < my_array[y].length; x ++)
      {
        System.out.format("'%c', ", my_array[y][x], x, y);
      }
      System.out.format("},\n");
    }
  }

}
