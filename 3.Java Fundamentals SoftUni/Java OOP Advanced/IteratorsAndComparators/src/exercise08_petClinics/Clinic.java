package exercise08_petClinics;

public class Clinic {

    private final static String INVALID_OPERATION_EXCEPTION = "Invalid Operation!";

    private String name;
    private int numberOfRooms;
    private Pet[] rooms;
    private int roomIndex;
    private boolean canAddToLeftRoom;
    private int leftIndex;
    private int rightIndex;
    private int occupiedRoomsCount;
    private boolean hasReleased;
    private int releaseIndex;

    public Clinic(String name, int numberOfRooms) {
        this.setName(name);
        this.setNumberOfRooms(numberOfRooms);
        this.rooms = new Pet[numberOfRooms];
        this.setRoomIndex(numberOfRooms / 2);
        this.setLeftIndex(this.roomIndex);
        this.setRightIndex(this.roomIndex);
        this.setOccupiedRoomsCount(0);
        this.setCanAddToLeftRoom(true);
        this.setReleaseIndex(this.roomIndex);

    }

    public boolean addPetToClinic(Pet pet) {
        if (this.roomIndex >= 0 && this.rooms[roomIndex] == null) {
            this.rooms[roomIndex] = pet;
            this.occupiedRoomsCount++;
            changeIndex();
            return true;
        }
        return false;
    }

    public void releasePet() {
        if (this.occupiedRoomsCount == 0) {
            this.hasReleased = false;
            System.out.println("false");
            return;
        }
        int currentIndex = this.releaseIndex;
        while (true) {
            if (this.rooms[currentIndex] != null) {
                this.rooms[currentIndex] = null;
                this.hasReleased = true;
                this.occupiedRoomsCount--;
                System.out.println("true");
                break;
            }
            currentIndex = (currentIndex + 1) % this.rooms.length;
            if (currentIndex % this.releaseIndex == 0) {
                System.out.println("false");
                break;
            }
        }
    }

    public boolean hasEmptyRooms() {
        return this.occupiedRoomsCount < this.numberOfRooms;
    }

    private void changeIndex() {
        if (this.canAddToLeftRoom) {
            this.canAddToLeftRoom = false;
            this.roomIndex = --leftIndex;
        } else {
            this.canAddToLeftRoom = true;
            this.roomIndex = ++rightIndex;
        }
    }

    public void setCanAddToLeftRoom(boolean canAddToLeftRoom) {
        this.canAddToLeftRoom = canAddToLeftRoom;
    }

    public void setLeftIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }

    public void setOccupiedRoomsCount(int occupiedRoomsCount) {
        this.occupiedRoomsCount = occupiedRoomsCount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfRooms() {
        return this.numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        if (numberOfRooms % 2 == 0) {
            throw new IllegalArgumentException(INVALID_OPERATION_EXCEPTION);
        }
        this.numberOfRooms = numberOfRooms;
    }

    public void setRoomIndex(int roomIndex) {
        this.roomIndex = roomIndex;
    }

    public void setReleaseIndex(int releaseIndex) {
        this.releaseIndex = releaseIndex;
    }

    public void setHasReleased(boolean hasReleased) {
        this.hasReleased = hasReleased;
    }

    public void printRoom(int roomNumber) {
        if (rooms[roomNumber - 1] == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(rooms[roomNumber - 1].toString());
        }
    }

    public void printAllRooms() {
        for (Pet room : rooms) {
            if (room == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(room.toString());
            }
        }
    }
}
