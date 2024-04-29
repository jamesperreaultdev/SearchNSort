package cs1501_p3;


public class DLB {


    DLBNode root = new DLBNode('=');
    int count = 0;


    public void add(String key,int index){ //index for the indirection

        DLBNode node = new DLBNode(key.charAt(0));
        int currentIndex = 1;
        if(root.getRight() == null){
            root.setRight(node);
            
            currentIndex = currentIndex +1;
            
            while(currentIndex <= key.length()){
                
            DLBNode iterNode = new DLBNode(key.charAt(currentIndex-1));
            node.setDown(iterNode);
           
            node = node.getDown();
            currentIndex = currentIndex +1;
            }
           
         DLBNode iterNode = new DLBNode('^');
         iterNode.index = index;
         node.setDown(iterNode);

         count = count +1;
         return;
        }
        else{
            addHelper(key,1,root.getRight(),index);
        }
    }

    private void addHelper(String key, int currentIndex, DLBNode node, int index){
        
        
        
        
       
    

        while(node.getRight() != null){
            if(currentIndex  > key.length()){
              
                if(node.getLet() == '^'){
                    node.index = index;
                    return;
                }
            }
            DLBNode currentNode = new DLBNode(key.charAt(currentIndex-1));
             if(node.getLet() == currentNode.getLet()){
                
                if(node.getDown() == null){
                    while(currentIndex <= key.length()){
                    DLBNode iterNode = new DLBNode(key.charAt(currentIndex-1));
                    node.setDown(iterNode);
                    node = node.getDown();
                    currentIndex = currentIndex +1;
                   
                    }
                   
                    DLBNode iterNode = new DLBNode('^');
                    iterNode.index = index;
                    count = count +1;
                    node.setDown(iterNode);
                   
                    return;
                    
                }
                else{
                addHelper(key, currentIndex+1, node.getDown(),index);
                return;
                } 
            }
                node = node.getRight();
        }

        if(currentIndex > key.length()){
            if(node.getLet() == '^'){
                node.index = index;
                return;
                
            }
            else{
              
                DLBNode iterNode = new DLBNode('^');
                iterNode.index = index;
                node.setRight(iterNode);
                count = count +1;
                return;
            }
        }


        DLBNode currentNode = new DLBNode(key.charAt(currentIndex-1));

        if(node.getLet() == currentNode.getLet()){
            
            if(node.getDown() == null){
                while(currentIndex <= key.length()){
                DLBNode iterNode = new DLBNode(key.charAt(currentIndex-1));
                node.setDown(iterNode);
                node = node.getDown();
                currentIndex = currentIndex +1;
               
                }
               
                DLBNode iterNode = new DLBNode('^');
                iterNode.index = index;
                count = count +1;
                node.setDown(iterNode);
               
                return;
                
            }
            else{
            addHelper(key, currentIndex+1, node.getDown(),index);
            return;
            } 
        }

        node.setRight(currentNode);
        node = node.getRight();

     

        currentIndex = currentIndex + 1;
        while(currentIndex <= key.length()){
            DLBNode iterNode = new DLBNode(key.charAt(currentIndex-1));
            node.setDown(iterNode);
         
            node = node.getDown();
            
            currentIndex = currentIndex +1;
        }
           
         DLBNode iterNode = new DLBNode('^');
         iterNode.index = index;
         node.setDown(iterNode);
         return;

    } 

    public void addHeap(String key,Car c){
        DLBNode node = new DLBNode(key.charAt(0));
        int currentIndex = 1;
        if(root.getRight() == null){
            root.setRight(node);
            
            currentIndex = currentIndex +1;
            
            while(currentIndex <= key.length()){
                
            DLBNode iterNode = new DLBNode(key.charAt(currentIndex-1));
            node.setDown(iterNode);
           
            node = node.getDown();
            currentIndex = currentIndex +1;
            }
           
         DLBNode iterNode = new DLBNode('^');
         iterNode.mileagePQ = new MinMPQ2();
         iterNode.pricePQ = new MinPPQ2();

         iterNode.mileagePQ.insert(c);
         iterNode.pricePQ.insert(c);

         
         node.setDown(iterNode);

         count = count +1;
         return;
        }
        else{
            

            addHeapHelper(key,1,root.getRight(),c);
        }
        
    }

    private void addHeapHelper(String key, int currentIndex, DLBNode node, Car c){
    
       

        while(node.getRight() != null){
            if(currentIndex  > key.length()){
              
                if(node.getLet() == '^'){
                    node.mileagePQ.insert(c);
                    node.pricePQ.insert(c);
                    return;
                }
            }
            DLBNode currentNode = new DLBNode(key.charAt(currentIndex-1));
    
           if(node.getLet() == currentNode.getLet()){
                
                if(node.getDown() == null){
                    while(currentIndex <= key.length()){
                    DLBNode iterNode = new DLBNode(key.charAt(currentIndex-1));
                    node.setDown(iterNode);
                    node = node.getDown();
                    currentIndex = currentIndex +1;
                   
                    }
                   
                    DLBNode iterNode = new DLBNode('^');
                    iterNode.mileagePQ = new MinMPQ2();
                    iterNode.pricePQ = new MinPPQ2();

                    iterNode.mileagePQ.insert(c);
                    iterNode.pricePQ.insert(c);
                    
                    count = count +1;
                    node.setDown(iterNode);
                   
                    return;
                    
                }
                else{
                    
                addHeapHelper(key, currentIndex+1, node.getDown(),c);
                return;
                } 
            }
                node = node.getRight();
        }

        
    
        if(currentIndex > key.length()){
            if(node.getLet() == '^'){
                node.mileagePQ.insert(c);
                node.pricePQ.insert(c);
                return;
                
            }
            else{
              
                DLBNode iterNode = new DLBNode('^');

                iterNode.mileagePQ = new MinMPQ2();
                iterNode.pricePQ = new MinPPQ2();
                
                iterNode.mileagePQ.insert(c);
                iterNode.pricePQ.insert(c);
                node.setRight(iterNode);
                count = count +1;
                return;
            }
        }
        DLBNode currentNode = new DLBNode(key.charAt(currentIndex-1));

        if(node.getLet() == currentNode.getLet()){
            
            if(node.getDown() == null){
                while(currentIndex <= key.length()){
                DLBNode iterNode = new DLBNode(key.charAt(currentIndex-1));
                node.setDown(iterNode);
                node = node.getDown();
                currentIndex = currentIndex +1;
               
                }
               
                DLBNode iterNode = new DLBNode('^');

                iterNode.mileagePQ = new MinMPQ2();
                iterNode.pricePQ = new MinPPQ2();
                
                iterNode.mileagePQ.insert(c);
                iterNode.pricePQ.insert(c);
               
                count = count +1;
                node.setDown(iterNode);
               
                return;
                
            }
            else{
            addHeapHelper(key, currentIndex+1, node.getDown(),c);
            return;
            } 
        }

        node.setRight(currentNode);
        node = node.getRight();

     

        currentIndex = currentIndex + 1;
        while(currentIndex <= key.length()){
            DLBNode iterNode = new DLBNode(key.charAt(currentIndex-1));
            node.setDown(iterNode);
         
            node = node.getDown();
            
            currentIndex = currentIndex +1;
        }
           
         DLBNode iterNode = new DLBNode('^');

         iterNode.mileagePQ = new MinMPQ2();
         iterNode.pricePQ = new MinPPQ2();
                
         iterNode.mileagePQ.insert(c);
         iterNode.pricePQ.insert(c);
         
         node.setDown(iterNode);
         return;

    } 

    public int contains(String key){
        if(root.getRight() == null){
           return 0; 
        }
        else{
            return containsHelper(key,root.getRight(),1);
        }

    }
    
    private int containsHelper(String key,DLBNode currentNode,int currentIndex){
        {
        if(currentIndex > key.length()){
           
            while(currentNode.getRight() != null){
              
                if(currentNode.getLet() == '^'){
                    return currentNode.index;
                }
                currentNode = currentNode.getRight();
            }
          
            if(currentNode.getLet() == '^'){
                return currentNode.index;
            }
           
            return 0;

            
        

        }

        
        while(currentNode.getRight() != null){
            
            if(currentNode.getLet() == key.charAt(currentIndex-1)){

                return containsHelper(key,currentNode.getDown(),currentIndex+1);
            }
            currentNode = currentNode.getRight();
        }

        if(currentNode.getLet() == key.charAt(currentIndex-1)){
          
            return containsHelper(key,currentNode.getDown(),currentIndex+1);      
    }



        return 0;


    
    }
}
    
    public DLBNode getNode(String key){
        if(root.getRight() == null){
           return null; 
        }
        else{
            return getNodeHelper(key,root.getRight(),1);
        }

    }

    private DLBNode getNodeHelper(String key,DLBNode currentNode,int currentIndex){
    
        {
        if(currentIndex > key.length()){
           
            while(currentNode.getRight() != null){
              
                if(currentNode.getLet() == '^'){
                    return currentNode;
                }
                currentNode = currentNode.getRight();
            }
          
            if(currentNode.getLet() == '^'){
                return currentNode;
            }
           
            return null;

            
        

        }

        
        while(currentNode.getRight() != null){
            
            if(currentNode.getLet() == key.charAt(currentIndex-1)){
               
                return getNodeHelper(key,currentNode.getDown(),currentIndex+1);
            }
            currentNode = currentNode.getRight();
        }

        if(currentNode.getLet() == key.charAt(currentIndex-1)){
          
         
            return getNodeHelper(key,currentNode.getDown(),currentIndex+1);      
    }



        return null;


    
    }

}

    public void removeNode(String key){
 
       
        getNode(key).let ='{';

        
       
    }

}   