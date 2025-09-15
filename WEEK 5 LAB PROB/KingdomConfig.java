import java.util.*;

final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedStructureTypes;
    private final Map<String,Integer> resourceLimits;

    public KingdomConfig(String n,int y,String[] types,Map<String,Integer> limits){
        if(n==null||n.isEmpty()||y<=0) throw new IllegalArgumentException();
        this.kingdomName=n;
        this.foundingYear=y;
        this.allowedStructureTypes=Arrays.copyOf(types,types.length);
        this.resourceLimits=new HashMap<>(limits);
    }
    public String getKingdomName(){return kingdomName;}
    public int getFoundingYear(){return foundingYear;}
    public String[] getAllowedStructureTypes(){return Arrays.copyOf(allowedStructureTypes,allowedStructureTypes.length);}
    public Map<String,Integer> getResourceLimits(){return new HashMap<>(resourceLimits);}
    public static KingdomConfig createDefaultKingdom(){
        return new KingdomConfig("DefaultLand",1000,new String[]{"Tower","Castle"},Map.of("Gold",1000));
    }
    public static KingdomConfig createFromTemplate(String type){
        if(type.equals("Magic")) return new KingdomConfig("Magica",1200,new String[]{"WizardTower"},Map.of("Mana",500));
        return createDefaultKingdom();
    }
}

class MagicalStructure {
    private final String structureId;
    private final long constructionTimestamp;
    private final String structureName;
    private final String location;
    private int magicPower;
    private boolean isActive;
    private String currentMaintainer;
    static final int MIN_MAGIC_POWER=0,MAX_MAGIC_POWER=1000;
    public static final String MAGIC_SYSTEM_VERSION="3.0";

    public MagicalStructure(String n,String l){this(n,l,100,false);}
    public MagicalStructure(String n,String l,int p){this(n,l,p,false);}
    public MagicalStructure(String n,String l,int p,boolean a){
        if(n==null||l==null||p<0||p>1000) throw new IllegalArgumentException();
        this.structureId=UUID.randomUUID().toString();
        this.constructionTimestamp=System.currentTimeMillis();
        this.structureName=n;this.location=l;
        this.magicPower=p;this.isActive=a;
    }
    public String getStructureName(){return structureName;}
    public String getLocation(){return location;}
    public int getMagicPower(){return magicPower;}
    public boolean isActive(){return isActive;}
    public void setMagicPower(int p){if(p>=0&&p<=1000) this.magicPower=p;}
    public void setActive(boolean a){this.isActive=a;}
    public void setCurrentMaintainer(String m){this.currentMaintainer=m;}
    @Override public String toString(){return structureName+"@"+location+" Power:"+magicPower;}
}

class WizardTower {
    private final int maxSpellCapacity;
    private List<String> knownSpells;
    private String currentWizard;
    public WizardTower(int cap){this.maxSpellCapacity=cap;this.knownSpells=new ArrayList<>();}
}

class EnchantedCastle {
    private final String castleType;
    private int defenseRating;
    private boolean hasDrawbridge;
    public EnchantedCastle(String t,int d,boolean dr){castleType=t;defenseRating=d;hasDrawbridge=dr;}
}

class MysticLibrary {
    private final Map<String,String> bookCollection;
    private int knowledgeLevel;
    public MysticLibrary(Map<String,String> books,int lvl){this.bookCollection=new HashMap<>(books);this.knowledgeLevel=lvl;}
}

class DragonLair {
    private final String dragonType;
    private long treasureValue;
    private int territorialRadius;
    public DragonLair(String type,long t,int r){dragonType=type;treasureValue=t;territorialRadius=r;}
}

class KingdomManager {
    private final List<Object> structures=new ArrayList<>();
    private final KingdomConfig config;
    public KingdomManager(KingdomConfig c){this.config=c;}
    public static boolean canStructuresInteract(Object s1,Object s2){return s1.getClass()!=s2.getClass();}
    public static String performMagicBattle(Object a,Object d){return a.getClass().getSimpleName()+" vs "+d.getClass().getSimpleName();}
    public static int calculateKingdomPower(Object[] s){return s.length*100;}
    private String determineStructureCategory(Object s){return s.getClass().getSimpleName();}
    public void addStructure(Object s){structures.add(s);}
    public static void main(String[] args){
        KingdomConfig cfg=KingdomConfig.createDefaultKingdom();
        KingdomManager km=new KingdomManager(cfg);
        km.addStructure(new MagicalStructure("Tower","Hill"));
        System.out.println(calculateKingdomPower(km.structures.toArray()));
    }
}
