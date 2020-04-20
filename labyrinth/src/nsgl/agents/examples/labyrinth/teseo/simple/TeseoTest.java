package nsgl.agents.examples.labyrinth.teseo.simple;

/**
*
* @author Tatiana
*/
public class TeseoTest extends SimpleTeseoAgentProgram {

   public TeseoTest() {}
   
   @Override
   public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT, boolean FAIL) {
   	System.out.println("OTRO PASO");
   	System.out.println(FAIL);

       if (MT) {
       	System.out.println("MT");
       	return -1; 	//Meta
       }
       if (!PI) {
       	System.out.println("!PI");
       	return 3; 	// No hay pared a la izquierda
       }
       if (!PF) {
       	System.out.println("!PF");
       	return 0;	// No hay pared al frente
       }
       if (!PD) {
       	System.out.println("!PD");
       	return 1;	// No hay pared a la derecha
       }
       return 2;
   }   
}


