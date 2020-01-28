static int pageCount(int n, int p) {
    int wantedPage = p/2;
    int lastPage = n/2;
    return Math.min(lastPage-wantedPage, wantedPage-0);
}