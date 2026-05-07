class WordDictionary {

    class TrieNode{
        TrieNode [] children;
        boolean isEnd;

        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(root, word.toCharArray(), 0);
    }

    private boolean search(TrieNode root, char[] word, int index){
        if(root == null) return false;
        if(index == word.length ){
            return root.isEnd;
        }
        
        if(word[index] == '.'){
            for(int i=0; i< 26; i++){
                if(search(root.children[i], word, index+1)){
                    return true;
                }
            }
            return false;
        }
        return search(root.children[word[index] - 'a'], word, index+1);
        
    }
}
