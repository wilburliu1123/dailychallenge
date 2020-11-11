public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int len = req_skills.length, pLen = people.size();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(req_skills[i], i);
        }
        Set<Integer>[] skillArr = new Set[1 << len];
        skillArr[0] = new HashSet<>();
        for (int ppl = 0; ppl < pLen; ppl++) {
            int pSkill = 0;
            for (String skills : people.get(ppl)) {
                pSkill |= 1 << (map.get(skills));
            }

            for (int k = 0; k < skillArr.length; k++) {
                if (skillArr[k] == null) continue;
                Set<Integer> curSkills = skillArr[k];
                int combined = k | pSkill;
                if (combined == k) continue;
                if (skillArr[combined] == null || skillArr[combined].size() > curSkills.size() + 1) {
                    Set<Integer> cSkills = new HashSet<>(curSkills);
                    cSkills.add(ppl);
                    skillArr[combined] = cSkills;
                }
            }
        }
        Set<Integer> resSet = skillArr[(1 << len) - 1];
        int[] res = new int[resSet.size()];
        int pos = 0;
        for (Integer n : resSet) {
            res[pos++] = n;
        }
        return res;
}