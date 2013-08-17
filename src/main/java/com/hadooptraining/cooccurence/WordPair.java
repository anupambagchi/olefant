package com.hadooptraining.cooccurence;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.Text;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class WordPair implements WritableComparable<WordPair> {
    private Text word;
    private Text neighbor;

    /**
     * Default constructor. Creates empty fields.
     */
    public WordPair() {
        this.word = new Text();
        this.neighbor =  new Text();
    }

    public WordPair(String word, String neighbor) {
        this.word = new Text();
        this.neighbor =  new Text();
        this.word.set(word);
        this.neighbor.set(neighbor);
    }

    /**
     * Set the values of all fields in this object.
     * @param word
     * @param neighbor
     */
    public void set (String word, String neighbor)
    {
        this.word.set(word);
        this.neighbor.set(neighbor);
    }

    public Text getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word.set(word);
    }

    public Text getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(String neighbor) {
        this.neighbor.set(neighbor);
    }


    /**
     * Given a DataInput object, this method will read its fields from DataInput.
     * @param in
     * @throws java.io.IOException
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        word.readFields(in);
        neighbor.readFields(in);
    }

    /**
     * Given a DataOutput object, this method will write its values to DataOutput.
     * @param out
     * @throws IOException
     */
    @Override
    public void write(DataOutput out) throws IOException {
        word.write(out);
        neighbor.write(out);
    }

    /**
     * A comparison rule for sorting of values. Used by Iterable template.
     * @param o
     * @return
     */
    @Override
    public int compareTo(WordPair o) {
        if (word.compareTo(o.word) == 0) {
            return neighbor.compareTo(o.neighbor);
        } else
            return word.compareTo(o.word);
    }

    /**
     * A method used to calculate assignment of reducers based on key.
     * @return
     */
    public int hashCode() {
        return word.hashCode();
    }

    public String toString() {
        return "[" + word.toString() + "," + neighbor.toString() + "]";
    }
}
