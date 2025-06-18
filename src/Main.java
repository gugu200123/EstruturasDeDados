public class Main {
    public static void main(String[] args) {
        UniBHList<Integer> myList = new UniBHList<>();

        System.out.println("A lista está vazia? " + myList.isEmpty()); 

        System.out.println("\n--- Inserindo elementos ---");
        for (int i = 0; i < 5; i++) {
            myList.insertAtBeginning(i + 1);
        }
        System.out.println(myList); 

      
        System.out.println("Tamanho da lista: " + myList.size()); 

      
        try {
            System.out.println("Pesquisando pelo item 3: " + myList.search(3)); 
            System.out.println("Pesquisando pelo item 10: ");
            myList.search(10); 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("\nInserindo 99 após a posição 2 (valor 3):");
            myList.insertAfter(2, 99);
            System.out.println(myList); 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("\nRemovendo o item com valor 4:");
            myList.removeByValue(4);
            System.out.println(myList); 
            System.out.println("Removendo o item com valor 100:");
            myList.removeByValue(100); 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("\nRemovendo o item na posição 3 (valor 2):");
            myList.removeAtIndex(3);
            System.out.println(myList); 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("\nModificando o elemento na posição 1 (valor 3) para 77:");
            myList.set(1, 77);
            System.out.println(myList);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        System.out.println("\nA lista está vazia? " + myList.isEmpty());
    }
}
