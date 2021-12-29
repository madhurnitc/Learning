    import java.util.*;

    class FileSharing {

        Map<Integer, Set<Integer>> chunks ;
        Map<Integer, Set<Integer>> users;
        PriorityQueue<Integer> pq;
        public FileSharing(int m) {
            chunks = new HashMap<>();
            users = new HashMap<>();
            pq = new PriorityQueue<>();
            pq.offer(1);

        }

        public int join(List<Integer> ownedChunks) {

            int id = pq.isEmpty() ? users.size()+1: pq.poll();
            users.put(id, new TreeSet<>(ownedChunks));
            for(int chunk : ownedChunks) {
                chunks.computeIfAbsent(chunk , key-> new TreeSet<>()).add(id);
            }

            return id;
        }

        public void leave(int userID) {
            pq.offer(userID);
            Set<Integer>  chunksOwned = users.get(userID);
            chunksOwned.stream().forEach(c-> chunks.get(c).remove(userID));
            users.remove(userID);
        }

        public List<Integer> request(int userID, int chunkID) {
            List<Integer> result = new ArrayList<>(chunks.getOrDefault(chunkID, new HashSet<>()));
            if(!result.isEmpty()) {
                users.get(userID).add(chunkID);
                chunks.get(chunkID).add(userID);
            }
            return result;
        }
    }