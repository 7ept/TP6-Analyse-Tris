public void bubbleSort() {
    int n = this.taille; 

    if (n <= 1) {
        return;
    }

    for (int i = n - 1; i > 0; i--) {

        Node current = this.head; 

        for (int j = 0; j < i; j++) {

            if (current.valeur > current.next.valeur) {

                int temp = current.valeur;
                current.valeur = current.next.valeur;
                current.next.valeur = temp;
            }

            current = current.next;
        }
    }
}