package org.example.adt;

public class StaticPriorityQueue implements PriorityQueue{

    private static final int MAX = 10000;

    private final int[] values;
    private final int[] priorities;
    private int count;

    public StaticPriorityQueue() {
        this.values = new int[MAX];
        this.priorities = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getFirst() {
        if(isEmpty()){
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return values[0];
    }

    @Override
    public int getPriority(){
        if(isEmpty()){
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return priorities[0];
    }


    @Override
    public void remove() {
        if(isEmpty()){
            throw new RuntimeException("Cola vacía");
        }
        for(int i = 0; i < count - 1; i++) {
            this.values[i] = this.values[i+1];
            this.priorities[i] = this.priorities[i+1];
        }
        count--;
    }

    @Override
    public void add(int value, int priority) {
        if(this.count == MAX){
            throw new RuntimeException("La cola está llena");
        }

        //COLA CON PRIORIDAD VACÍA, AGREGO LOS VALORES EN LA PRIMERA POSICION DE CADA ARREGLO
        if(this.isEmpty()){
            this.values[0] = value;
            this.priorities[0] = priority;
            this.count++;
            return;
        }



        // VERIFICO QUE LA PRIORIDAD QUE ME PASAN POR PARÁMETRO ES MAS GRANDE QUE LA ÚLTIMA PRIORIDAD (VA A LO ÚLTIMO)
        // EJ:
        // COLA CON PRIORIDAD BASE:

        // values[3,8,5,0,0,...]
        // priorities[1,2,3,0,0,...]

        // SI MI PRIORIDAD ES 4 O MAS, VA A IR A LO ÚLTIMO

        // POR EJEMPLO PASO COMO VALORES:  value = 1 , priority = 5

        // COLA CON PRIORIDAD NUEVA:

        // values[3,8,5,1,0,...]
        // priorities[1,2,3,5,0,...]


        if(this.priorities[count-1] <= priority){
            this.values[count] = value;
            this.priorities[count] = priority;
            this.count++;
            return;
        }

        if(this.priorities[0] > priority){
            // VOY DE ATRAS PARA ADELANTE, SIN MIRAR EL PRIMER ELEMENTO (PORQUE ESE VA A SER EL DE LA NUEVA PRIORIDAD)
            for(int i = this.count; i>0; i--){
                this.values[i] = this.values[i-1];
                this.priorities[i] = this.priorities[i-1];
            }
            this.values[0] = value;
            this.priorities[0] = priority;
            return;
        }



        // BUSCO DONDE TENGO QUE METER EL NUEVO NUMERO
        // VA A ESTAR ENTRE EL SEGUNDO ELEMENTO Y EL ANTEÚLTIMO
        int index = -1;
        for (int i=1; i<this.count; i++){
            if(this.priorities[i-1] <= priority && this.priorities[i+1] > priority){
                index = i;
                break;
            }
        }

        this.values[this.count] = value;
        this.count++;
    }

    @Override
    public boolean isEmpty() { return this.count == 0; }
}
