package de.uulm.sp.pvs.util;

import de.uulm.sp.oop.sokoban.Exceptions.SokobanException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SokobanLevel {
    enum Difficulty{
        NONE, EASY, MEDIUM, HARD, IMPOSSIBLE
    }

    private List<String> authors;
    private final String Levelname;
    private final Difficulty difficulty;
    private final int width = 0;
    private final int height = 0;
    private char[][] board;

    public SokobanLevel(String path) throws SokobanException{
        Schema schema = null;
        // Load the schema
        try {
            schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File("sokoban_missing.xsd"));
        } catch (SAXException saxe){
            throw new SokobanException("Error reading schema!", saxe);
        }

        // Create document builder
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        fact.setSchema(schema);
        fact.setNamespaceAware(true);

        DocumentBuilder documentBuilder;
        try {
            documentBuilder = fact.newDocumentBuilder();
        }catch (ParserConfigurationException ex){
            throw new SokobanException("Error in parser configuration", ex);
        }
        documentBuilder.setErrorHandler(new DocumentErrorHandler());

        // Read Document
        Document doc;
        try{
            doc = documentBuilder.parse(path);
        } catch(SAXException saxe){
            throw new SokobanException("Error while parsing file: " + saxe.getMessage(), saxe);
        }catch (IOException ioe){
            throw new SokobanException("Error while reading file:", ioe);
        }

        // Handle the documents content
        NodeList authorNodes = doc.getElementsByTagName("Author");
        authors = new LinkedList<>();
        for (int i = 0; i < authorNodes.getLength(); i++){
            authors.add(authorNodes.item(i).getTextContent());
        }
        Levelname = doc.getElementsByTagName("LevelName").item(0).getTextContent();

        NodeList difficultyNodes = doc.getElementsByTagName("Difficulty");
        if (difficultyNodes.getLength() == 0){
            difficulty = Difficulty.NONE;
        }else {
            difficulty = Difficulty.valueOf(difficultyNodes.item(0).getTextContent());
        }

        Node levelNode = doc.getElementsByTagName("LevelData").item(0);
        int width = Integer.parseInt(levelNode.getAttributes().getNamedItem("width").getTextContent());
        int height = Integer.parseInt(levelNode.getAttributes().getNamedItem("height").getTextContent());
        board = new char[height][];
        String[] levelString = levelNode.getTextContent().split("\n|\r");
        for (int i = 0; i < height; i++){
            board[i] = levelString[i].toCharArray();
            if( board[i].length != width){
                throw new SokobanException("Width should be " + width + " but is " + board[i].length, new Throwable());
            }
        }
    }

    public Pair<Integer, Integer> findPlayer(char[][] board){
        for(int i = 0; i < board.length; i++){
            for( int j = 0; j < board[0].length; j++){
                if(board[i][j] == '@')return new Pair<>(i,j);
            }
        }
        return new Pair<>(-1,-1);
    }


    public boolean moveNorth(char[][] board){ return move(board, new Pair<>(-1,0));}
    public boolean moveSouth(char[][] board){ return move(board, new Pair<>(1,0));}
    public boolean moveWest(char[][] board){ return move(board, new Pair<>(0,-1));}
    public boolean moveEast(char[][] board){ return move(board, new Pair<>(0,1));}


    public String sokobanToString(char[][] board){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++){
            for(char c : board[i]){
                sb.append(c);
            }
            if(i < board.length-1)sb.append("\n");
        }
        return sb.toString();
    }

    private boolean move(char[][] board, Pair<Integer,Integer> offset){
        int offsetX = offset.getFirst();
        int offsetY = offset.getSecond();
        Pair<Integer,Integer> playerPos = findPlayer(board);
        if(playerPos.getFirst() == -1)return false;

        if(board[playerPos.getFirst() + offsetX][playerPos.getSecond() + offsetY] == '.'){
            board[playerPos.getFirst() + offsetX][playerPos.getSecond() + offsetY] = '@';
            board[playerPos.getFirst()][playerPos.getSecond()] = '.';
            return true;
        }else if(board[playerPos.getFirst() + offsetX][playerPos.getSecond() + offsetY] == '$' && board[playerPos.getFirst() + 2*offsetX][playerPos.getSecond() + 2*offsetY]== '.'){
            board[playerPos.getFirst() + offsetX][playerPos.getSecond() + offsetY] = '@';
            board[playerPos.getFirst() + 2*offsetX][playerPos.getSecond() + 2*offsetY] = '$';
            board[playerPos.getFirst()][playerPos.getSecond()] = '.';
            return true;
        }
        return false;
    }

}
