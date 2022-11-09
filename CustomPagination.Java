    /**
     * This method will prepare Preview Model  for PageData
     * @param data of Collection {@link  List<T>}
     * @param pageable          {@link   Pageable}
     * @return                  {@link PageData  }
     */
    public static <T> PageData buildCustomPagedData(List<T> data, Pageable pageable) {
        List<T> model = new ArrayList<>();
        int start = VALUE_ZERO;
        if (!Objects.equals(pageable.getPageNumber(), FIRST_INDEX)) {
            start = (pageable.getPageNumber() * pageable.getPageSize());
        }
        for (int i = start; i < start + pageable.getPageSize(); i++) {
            if (i < data.size()) {
                model.add(data.get(i));
            } else {
                break;
            }
        }
        return PageData.builder()
                .model(model)
                .totalElements(data.size())
                .currentPage(pageable.getPageNumber() + INT_ONE)
                .totalPages((data.size() / pageable.getPageSize()) + INT_ONE)
                .build();
    }
