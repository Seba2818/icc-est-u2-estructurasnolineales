package collections.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import models.Contacto;

public class Maps {
    
    public Map <String, Integer> contruirHashMap(){
        Map <String, Integer> m = new HashMap<>();
        m.put("A", 10);
        m.put("B", 20);
        m.put("C", 30);
        m.put("A", 50);
        

        System.out.println(m.size());
        System.out.println(m);

        for(int i = 0; i<m.size(); i++){
            System.out.println(m.values().toArray()[i]);
        }

        for (String key : m.keySet()){
            System.out.println(key);
            
        }

        System.out.println(m.get("A"));
        System.out.println(m.get("B"));
        System.out.println(m.get("F"));

        m.putIfAbsent("F", 100);
        m.putIfAbsent("A", 200);
        System.out.println(m);
        return m;
    }

    public Map <String, Integer> cTreeMap(){
        Map <String, Integer> mapa = new TreeMap<>();
        mapa.put("a", 10);
        mapa.put("AB", 20);
        mapa.put("A", 30);
        mapa.put("aA", 50);
        return mapa;
    }

    public Set<Contacto> ordenarUnicos(List<Contacto> contactos){
        
        // Retornar contactos unicos
        // unicos -> nombre
        Set<Contacto> nueva = new TreeSet<>(

            (c1, c2) -> {
                if(c1.getNombre().equals(c2.getNombre())){
                    return 0;
                }
                return c1.getApellido().compareTo(c2.getApellido());
            });
        for (Contacto contacto : contactos){
            nueva.add(contacto);
        }
        return nueva;
    }
}
