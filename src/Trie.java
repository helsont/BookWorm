import java.lang.String;

/**
 * implements a trie for storing strings/string prefixes
 *
 * @author Owen Astrachan
 * @version $Id: Trie.java,v 1.1 1996/12/01 00:07:21 ola Exp ola $
 */


public class Trie {
    /**
     * create a new Trie (characters a-z)
     */

    public Trie() {
        myLinks = new Trie[ALPH];
        myIsWord = false;
    }

    /**
     * Add a string to the trie
     *
     * @param s The string added to Trie
     */

    public void addString(String s) {
        Trie t = this;
        int k;
        int limit = s.length();
//        s = s.toLowerCase();
        for (k = 0; k < limit; k++) {
            if (!Character.isLetter(s.charAt(k))) {
                continue;
            }
            int index = s.charAt(k) - 'A';
            // Once we subtract 'A', the range of 'A' to 'z' decreases by 57.
            if (index > 57 || index < 0) {
                continue;
            }
            if (t.myLinks[index] == null) {
                t.myLinks[index] = new Trie();
            }
            t = t.myLinks[index];
        }
        t.myIsWord = true;
    }

    public void addCString(char s[]) {
        Trie t = this;
        int k = 0;
        while (s[k] != '\0') {
            int index = s[k] - 'a';
            if (t.myLinks[index] == null) {
                t.myLinks[index] = new Trie();
            }
            t = t.myLinks[index];
            k++;
        }
        t.myIsWord = true;
    }

    /**
     * print every word in the trie, one per line
     */

//    public void Print() {
//        //DoPrint("",this);
//        apply(new PrintRecorder());
//    }

//    public void apply(Recorder rec) {
//        char[] buffer = new char[BUFSIZ];
//        doApply(rec, 0, buffer, this);
//    }
//
//    private void doApply(Recorder rec, int index, char buffer[], Trie t) {
//        if (t != null) {
//            if (t.myIsWord) {
//                rec.record(new String(buffer, 0, index));
//            }
//            int k;
//            for (k = 0; k < ALPH; k++) {
//                if (t.myLinks[k] != null) {
//                    buffer[index] = (char) (k + 'a');
//                    doApply(rec, index + 1, buffer, t.myLinks[k]);
//                }
//            }
//        }
//    }

    void DoPrint(String s, Trie t)   // now superflous (see doApply)
    {
        if (t != null) {
            if (t.myIsWord) {
                System.out.println(s);
            }
            int k;
            for (k = 0; k < ALPH; k++) {
                if (t.myLinks[k] != null) {
                    DoPrint(s + (char) (k + 'a'), t.myLinks[k]);
                }
            }
        }
    }

    /**
     * determine if a word is in the trie (here or below)
     *
     * @param s The string searched for
     * @return true iff s is in trie (rooted here)
     */

    public boolean isWord(String s) {
        Trie t = this;
        int k;
        int limit = s.length();
        for (k = 0; k < limit; k++) {
            if (!Character.isLetter(s.charAt(k))) {
                continue;
            }
            int index = s.charAt(k) - 'A';
            if (t.myLinks[index] == null) return false;
            t = t.myLinks[index];
        }
        return t.myIsWord;
    }

    /**
     * @return true iff path from some root to this node is a word
     */

    public boolean isWord() {
        return myIsWord;
    }

    /**
     * @param ch Character used to index node (find child)
     * @return Trie formed from this by indexing using ch
     */

    Trie childAt(char ch) {
        return myLinks[ch - 'a'];
    }

    private static final int ALPH = 58;
    private static final int BUFSIZ = 1024;
    private Trie[] myLinks;
    private boolean myIsWord;
}
//
//class PrintRecorder implements Recorder {
//    public void record(Object o) {
//        System.out.println(o);
//    }
//
//    public void report() {
//        // nothing to do here
//    }
//}