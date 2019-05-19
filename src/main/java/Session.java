public interface Session {
    public String render();
    public String render(ExtraSessionEvent... afterSessionEvents);
}
