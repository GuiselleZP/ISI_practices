/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nsgl.agents.examples.labyrinth.teseo.simple;

/**
 *
 * @author Jonatan
 */
public class TeseoTest extends SimpleTeseoAgentProgram {

	protected int[][] m = new int[100][100];
	protected int r;
	protected int c;
	protected int o;
	
    public TeseoTest() {
    	r = 50; c = 50; o = 0;
    	m[r][c] = 1;
    }
    // Are there roads that I have not traveled?
    public boolean roadNotTraveled() { 	
    	int left = m[r][c-1];
    	int up = m[r+1][c];
    	int right = m[r][c+1];
    	int down = m[r-1][c];
    	
    	boolean result = true;
    	
    	if((left != 0) && (up != 0) && (right != 0) && (down != 0))
    		result = false;   	
    	return result;
    }
    
    public void markWalls(boolean PI, boolean PF, boolean PD, boolean PA){
    	if(PI) m[r][c-1] = -1;
    	if(PF) m[r+1][c] = -1;
    	if(PD) m[r][c+1] = -1;
    	if(PA) m[r-1][c] = -1;
    }
    
    public int setOrientation(int o, int a) {
        switch( o ) {
        //case 0: a = a;	// head up		
        case 1:		// head right
        	switch(a){
	    		case 0: a = 3; break;
	    		case 1: a = 0; break;
	    		case 2: a = 1; break;
	    		default: a = 2; 
	    	}
        break;		
        case 2:		// head down
        	switch(a){
	    		case 0: a = 2; break;
	    		case 1: a = 3; break;
	    		case 2: a = 0; break;
	    		default: a = 1; 
	    	}
        break;		
        case 3:		// head left
        	switch(a){
	    		case 0: a = 1; break;
	    		case 1: a = 2; break;
	    		case 2: a = 3; break;
	    		default: a = 0; 
	    	}
        break;		
        }
        return a;
    }
    
    public int getWay() {
    	int a = -1;
    	
    	if(roadNotTraveled()) { //mark as visited and advance
    		switch( o ) {
            case 0:		// head up	
        		if(m[r][c-1] == 0) {
        			m[r][c-1] = 1;
        			a = 3;
        		}else if(m[r+1][c] == 0) {
        			m[r+1][c] = 1;
        			a = 0;		
        		}else if(m[r][c+1] == 0) {
        			m[r][c+1] = 1;
        			a = 1;
        		}else {
        			m[r-1][c] = 1;
        			a = 2;
        		}
            break;	
            case 1:		// head right
        		if(m[r+1][c] == 0) {
        			m[r+1][c] = 1;
        			a = 3;
        		}else if(m[r][c+1] == 0) {
        			m[r][c+1] = 1;
        			a = 0;
        		}else if(m[r-1][c] == 0) {
        			m[r-1][c] = 1;
        			a = 1;
        		}else {
        			m[r][c-1] = 1;
        			a = 2;
        		}
            break;		
            case 2:		// head down
            	if(m[r][c+1] == 0) {
            		m[r][c+1] = 1;
        			a = 3;
        		}else if(m[r-1][c] == 0) {
        			m[r-1][c] = 1;
        			a = 0;
        		}else if(m[r][c-1] == 0) {
        			m[r][c-1] = 1;
        			a = 1;
        		}else {
        			m[r+1][c] = 1;
        			a = 2;
        		}
            break;		
            case 3:		// head left
            	if(m[r-1][c] == 0) {
        			m[r-1][c] = 1;
        			a = 3;
        		}else if(m[r][c-1] == 0) {
        			m[r][c-1] = 1;
        			a = 0;
        		}else if(m[r+1][c] == 0) {
        			m[r+1][c] = 1;
        			a = 1;
        		}else {
        			m[r][c+1] = 1;
        			a = 2;
        		}
            break;		
            }
    	}else { // mark as wall and advance
    		switch( o ) {
            case 0:		// head up	
        		if(m[r][c-1] > 0) {
        			m[r][c-1] = -1;
        			a = 3;
        		}else if(m[r+1][c] > 0) {
        			m[r+1][c] = -1;
        			a = 0;		
        		}else if(m[r][c+1] > 0) {
        			m[r][c+1] = -1;
        			a = 1;
        		}else if(m[r-1][c] > 0) {
        			m[r-1][c] = -1;
        			a = 2;
        		}
            break;	
            case 1:		// head right
        		if(m[r+1][c] > 0) {
        			m[r+1][c] = -1;
        			a = 3;
        		}else if(m[r][c+1] > 0) {
        			m[r][c+1] = -1;
        			a = 0;
        		}else if(m[r-1][c] > 0) {
        			m[r-1][c] = -1;
        			a = 1;
        		}else if(m[r][c-1] > 0) {
        			m[r][c-1] = -1;
        			a = 2;
        		}
            break;		
            case 2:		// head down
            	if(m[r][c+1] > 0) {
        			m[r][c+1] = -1;
        			a = 3;
        		}else if(m[r-1][c] > 0) {
        			m[r-1][c] = -1;
        			a = 0;
        		}else if(m[r][c-1] > 0) {
        			m[r][c-1] = -1;
        			a = 1;
        		}else if(m[r+1][c] > 0) {
        			m[r+1][c] = -1;
        			a = 2;
        		}
            break;		
            case 3:		// head left
            	if(m[r-1][c] > 0) {
        			m[r-1][c] = -1;
        			a = 3;
        		}else if(m[r][c-1] > 0) {
        			m[r][c-1] = -1;
        			a = 0;
        		}else if(m[r+1][c] > 0) {
        			m[r+1][c] = -1;
        			a = 1;
        		}else if(m[r][c+1] > 0) {
        			m[r][c+1] = -1;
        			a = 2;
        		}
            break;		
            }
    	}
    	return a;
    }
    
    @Override
    public int accion(boolean PF, boolean PD, boolean PA, boolean PI, boolean MT, boolean FAIL) {
    	int a = -1;
    	m[r][c] = 1;
    	
    	System.out.println("NUEVO PASO");
    	System.out.println("r: "+r+" c: "+c);
    	System.out.println("\nANTES");
    	System.out.println("XXXX: "+m[r][c]+" r: "+r+" c: "+ (c));
    	System.out.println("left: "+m[r][c-1]+" r: "+r+" c: "+ (c-1));
    	System.out.println("up: "+m[r+1][c]+" r: "+(r+1)+" c: "+ (c));
    	System.out.println("right: "+m[r][c+1]+" r: "+(r)+" c: "+ (c+1));
    	System.out.println("down: "+m[r-1][c]+" r: "+(r-1)+" c: "+ (c));
    	System.out.println("o: "+o+" a: "+a);
    	
    	if (MT) {
    		m = new int[100][100];
    		return -1;
    	}
    	
    	System.out.println("\n");
    	System.out.println("PF: "+PF+" PD: "+PD+" PA: "+PA+" PI: "+PI);
    	
    	switch(o) {
    	case 0:		// head up
    		System.out.println("\nH up");
    		markWalls(PI, PF, PD, PA);
    		break;
    	case 1:		// head right
    		System.out.println("\nH rght");
    		markWalls(PA, PI, PF, PD);
    		break;
    	case 2:		// head down
    		System.out.println("\nH down");
    		markWalls(PD, PA, PI, PF);
    		break;
    	case 3:		// head left
    		System.out.println("\nH left");
    		markWalls(PF, PD, PA, PI);
    		break;
    	}
    	
    	System.out.println("\nDespues - 1");
    	System.out.println("left: "+m[r][c-1]+" r: "+r+" c: "+ (c-1));
    	System.out.println("up: "+m[r+1][c]+" r: "+(r+1)+" c: "+ (c));
    	System.out.println("right: "+m[r][c+1]+" r: "+(r)+" c: "+ (c+1));
    	System.out.println("down: "+m[r-1][c]+" r: "+(r-1)+" c: "+ (c));
    	System.out.println("a: "+a);
    	
    	a = getWay();
    	
    	System.out.println("\nDespues - 2");
    	System.out.println("left: "+m[r][c-1]+" r: "+r+" c: "+ (c-1));
    	System.out.println("up: "+m[r+1][c]+" r: "+(r+1)+" c: "+ (c));
    	System.out.println("right: "+m[r][c+1]+" r: "+(r)+" c: "+ (c+1));
    	System.out.println("down: "+m[r-1][c]+" r: "+(r-1)+" c: "+ (c));
    	System.out.println("a: "+a);

    	
        // Computing r, c, o
        switch( o ) {
        case 0:		// head up
        	switch(a){
        		case 0: r++; o=0; break;
        		case 1: c++; o=1; break;
        		case 2: r--; o=2; break;
        		default: c--; o=3; 
        	}
        break;		
        case 1:		// head right
        	switch(a){
        		case 0: c++; o=1; break;
        		case 1: r--; o=2; break;
        		case 2: c--; o=3; break;
        		default: r++; o=0;
        	}
        break;		
        case 2:		// head down
        	switch(a){
        		case 0: r--; o=2;break;
        		case 1: c--; o=3; break;
        		case 2: r++; o=0; break;
        		default: c++; o=2; 
        	}
        break;		
        case 3:		// head left
        	switch(a){
        		case 0: c--; o=3;break;
        		case 1: r++; o=0; break;
        		case 2: c++; o=1; break;
        		default: r--; o=2; 
        	}
        break;		
        }
        
    	System.out.println("o: "+o+"\n");
        
        return a;
    }
    
}