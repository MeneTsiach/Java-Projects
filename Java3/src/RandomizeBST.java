import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RandomizeBST implements TaxEvasionInterface{

    public static void main(String[] args) {
        RandomizeBST tree = new RandomizeBST();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int choice = scanner.nextInt();
        while (choice != 0){
            if (choice == 1) { //Insert LargeDepositor
                System.out.print("AFM: ");
                int AFM = scanner.nextInt();
                System.out.print("First name: ");
                String firstName = scanner.next();
                System.out.print("Last name: ");
                String lastName = scanner.next();
                System.out.print("Savings: ");
                double savings = scanner.nextDouble();
                System.out.print("TaxedIncome: ");
                double taxedIncome = scanner.nextDouble();
                tree.insert(new LargeDepositor(AFM, firstName, lastName, savings, taxedIncome));

            } else if (choice == 2) { //Load file with LargeDepositors
                System.out.println("Please insert the path of the file to load the LargeDepositors");
                tree.load(scanner.next());

            } else if (choice == 3) { //Update savings for a LargeDepositor
                System.out.print("Choose LargeDepositor by AFM: ");
                int tempAFM = scanner.nextInt();
                System.out.print("Insert savings to update: ");
                double tempSavings = scanner.nextDouble();
                tree.updateSavings(tempAFM, tempSavings);

            } else if (choice == 4) { //Search LargeDepositor using AFM
                System.out.print("Type AFM for the LargeDepositor to search: ");
                int searchAFM = scanner.nextInt();
                System.out.println(tree.searchByAFM(searchAFM));

            } else if (choice == 5) { //Search LargeDepositors using a last name
                System.out.print("Type the last name to search LargeDepositors: ");
                String searchLastName = scanner.next();
                StringDoubleEndedQueue<LargeDepositor> tempQueue = tree.searchByLastName(searchLastName);
                System.out.println("All LargeDepositors with last name: " + searchLastName);
                tempQueue.printQueue(System.out);

            } else if (choice == 6) { //Remove LargeDepositor using AFM
                System.out.print("Type AFM for the LargeDepositor to remove: ");
                int removeAFM = scanner.nextInt();
                tree.remove(removeAFM);

            } else if (choice == 7) { //Get mean savings
                System.out.println(tree.getMeanSavings());
                
            } else if (choice == 8) { //Print Top 'K' LargeDepositors (K being a number you will type)
                System.out.print("Please choose k top LargeDepositors to print: ");
                int topLargeDepositors = scanner.nextInt();
                //tree.printTopLargeDepositors(topLargeDepositors);

            } else if (choice == 9) { //Print LargeDepositors using AFM
                tree.printByAFM();
                
            } else if (choice == 0) { //Exit the program
                choice = 0;
                break;

            }
            printMenu();
            choice = scanner.nextInt();  
        }
    }

    private static void printMenu(){
        System.out.println("\n---------------------------------------------");
        System.out.println("1. Insert LargeDepositor");
        System.out.println("2. Load file with LargeDepositors");
        System.out.println("3. Update savings for a LargeDepositor");
        System.out.println("4. Search LargeDepositor using AFM");
        System.out.println("5. Search LargeDepositors using a last name");
        System.out.println("6. Remove LargeDepositor using AFM");
        System.out.println("7. Get mean savings");
        System.out.println("8. Print Top 'K' LargeDepositors (K being a number you will type)");
        System.out.println("9. Print LargeDepositors using AFM");
        System.out.println("0. Exit the program");
        System.out.println("---------------------------------------------");
    }

    private TreeNode root;
    private int size;

    public RandomizeBST() {
        this.root = null;
        this.size = 0;
    }


    private TreeNode rootIn(TreeNode root, LargeDepositor item, TreeNode parent) {

        if (root == null) {
            TreeNode node = new TreeNode(item);
            node.setParent(parent);
            ++size;
            return node;
        }

        int itemKey = item.key();
        int rootKey = root.getItem().key();

        if (itemKey == rootKey) {
            System.out.println("LargeDepositor that has ID : " + item.key() + "already exists on the list.");
            return root;
        }

        if (itemKey < rootKey) {
            TreeNode leftSubtreeRoot = this.rootIn(root.getLeft(), item, root);
            root.setLeft(leftSubtreeRoot);
            root = this.rotateRight(root);
        }
        else {
            TreeNode rightSubtreeRoot = this.rootIn(root.getRight(), item, root);
            root.setRight(rightSubtreeRoot);
            root = this.rotateLeft(root);
        }

        return root;
    }


    @Override
    public void insert(LargeDepositor item) {
        root = rootIn(root, item, null);
    }

    private TreeNode rotateLeft(TreeNode pivot){
        TreeNode parent = pivot.getParent();
        TreeNode child = pivot.getRight();

        if (parent == null){
            root = child;
        } else if (parent.getLeft() == pivot){
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }

        child.setParent(pivot.getParent());
        pivot.setParent(child);

        pivot.setRight(child.getLeft());
        if (child.getLeft() != null) {
            child.getLeft().setParent(pivot);
        }
        child.setLeft(pivot);
        return child;
    }


    private TreeNode rotateRight(TreeNode pivot) {
        TreeNode parent = pivot.getParent();
        TreeNode child = pivot.getLeft();

        if (parent == null) {
            root = child;
        } else if (parent.getLeft() == pivot) {
            parent.setLeft(child);
        }
        else {
            parent.setRight(child);
        }

        child.setParent(pivot.getParent());
        pivot.setParent(child);

        pivot.setLeft(child.getRight());
        if (child.getRight() != null) {
            child.getRight().setParent(pivot);
        }
        child.setRight(pivot);
        return child;
    }

    public int getSize(){
        return size;
    }

    @Override
    public void load(String filename) {
        try{
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()){
                String data = sc.nextLine();
                String[] arr = data.split(" ");
                if (arr.length == 5) {
                    int AFM = Integer.parseInt(arr[0]);
                    String firstName = arr[1];
                    String lastName = arr[2];
                    double savings = Double.parseDouble(arr[3]);
                    double taxedIncome = Double.parseDouble(arr[4]);
                    insert(new LargeDepositor(AFM, firstName, lastName, savings, taxedIncome));
                } else {
                    System.err.println("Wrong type of file used.");
                }
            }
            sc.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error.");
            fileNotFoundException.printStackTrace();
        }
    }

    @Override
    public void updateSavings(int AFM, double savings) {
        LargeDepositor tempLargeDepositor = searchByAFM(AFM);
        if (tempLargeDepositor != null){
            tempLargeDepositor.setSavings(savings);
        } else {
        System.err.println("The LargeDepositor with this AFM does not exist.");
        return;
        }
    }

    @Override
    public LargeDepositor searchByAFM(int AFM) {
        TreeNode temp = root;
        while (temp.getItem().key() != AFM){
            if (AFM > temp.getItem().key()){
                temp = temp.getRight();               
            }   
            else {
                temp = temp.getLeft();
            }
            if (temp == null){
                return null;
            }
        }
        return temp.getItem();
    }

    @Override
    public StringDoubleEndedQueue<LargeDepositor> searchByLastName(String last_name) {
        StringDoubleEndedQueue<LargeDepositor> susQueue = new StringDoubleEndedQueueImpl<>();
        helpSearchLastName(susQueue, root, last_name);
        return susQueue;
    }

    private void helpSearchLastName(StringDoubleEndedQueue<LargeDepositor> queue, TreeNode treeNode, String last_name){
        if(treeNode != null){
            helpSearchLastName(queue, treeNode.getLeft(), last_name);
            if (treeNode.getItem().getLastName().equals(last_name)) {
                queue.addLast(treeNode.getItem());
                if (queue.size()%5 == 0){
                    queue.printQueue(System.out);
                }
            }
            helpSearchLastName(queue, treeNode.getRight(), last_name);
        }
    }

    @Override
    public void remove(int AFM) {
        LargeDepositor tempLargeDepositor = searchByAFM(AFM);

        if (tempLargeDepositor == null){
            System.err.println("Cannot remove an element that does not exist.");
            return;
        }

        TreeNode temp = root;
        TreeNode parent = null;

        while (temp != null) {
            if(temp.getItem().key() == AFM) {
                break;
            }
            parent = temp;
            if(temp.getItem().key() < 0) {
                temp = temp.getRight();
            } else {
                temp = temp.getLeft();
            }
        }

        TreeNode replace = null;

        if(temp.getLeft() == null) {
            replace = temp.getRight();
        } else if (temp.getRight() == null) {
            replace = temp.getLeft();
        } else {
            TreeNode findCurrent = temp.getRight();

            while (findCurrent.getLeft() != null) {
                findCurrent = findCurrent.getLeft();
            }

            remove(findCurrent.getItem().key());
            findCurrent.setLeft(temp.getLeft());
            findCurrent.setRight(temp.getRight());

            replace = findCurrent;
        }

        if (parent == null)
            root = replace;
        else {
            if(parent.getLeft() == temp)
                parent.setLeft(replace);
            if(parent.getRight() == temp)
                parent.setRight(replace);
        }
    }

    private int countLargeDepositors(TreeNode treeNode){
        if (treeNode == null)
            return 0;
        return 1 + countLargeDepositors(treeNode.getLeft()) + countLargeDepositors(treeNode.getRight());
    }

    private double countSavings(TreeNode treeNode){
        if (treeNode == null)
            return 0.0;
        return treeNode.getItem().getSavings() + countSavings(treeNode.getLeft()) + countSavings(treeNode.getRight());
    }

    @Override
    public double getMeanSavings() {
        return countSavings(root) / countLargeDepositors(root);
    }

    /*private void helperTopLargeDepositors(PriorityQueueInterface susPQ,StringDoubleEndedQueue<LargeDepositor> topLargeDepositors, TreeNode treeNode, int top_k){
        if (treeNode == null)
            return;
        helperTopLargeDepositors(susPQ, topLargeDepositors, treeNode.getLeft(), top_k);
        if (treeNode.getItem().getTaxedIncome() < 8000) {
            topLargeDepositors.addLast(treeNode.getItem());
        }
        else{
            susPQ.add(treeNode.getItem());
        }
        helperTopLargeDepositors(susPQ, topLargeDepositors,treeNode.getRight(), top_k);

    }*/
   
    //@Override
    /*public void printTopLargeDepositors(int top_k) {

        PriorityQueueInterface<LargeDepositor> susPQ = new HeapPriorityQueue<>(new LargeDepositorComparator());
        StringDoubleEndedQueue<LargeDepositor> topLargeDepositors = new StringDoubleEndedQueueImpl<>();
        helperTopLargeDepositors(susPQ,topLargeDepositors, root, top_k);
        System.out.println("The top " + top_k + " LargeDepositors are: ");

        for (int i = 0; i < top_k; i++){
            if (!topLargeDepositors.isEmpty()) {
                System.out.println(topLargeDepositors.removeFirst());
            }
            else {
                System.out.println(susPQ.getMax());
            }
        }

    }*/

    @Override
    public void printByAFM() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(TreeNode treeNode) {
        if (treeNode == null)
            return;
        inOrderRecursive(treeNode.getLeft());
        System.out.println(treeNode.getItem());
        inOrderRecursive(treeNode.getRight());

    }
    
}