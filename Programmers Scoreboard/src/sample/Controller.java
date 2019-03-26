package sample;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.chart.CategoryAxis;
        import javafx.scene.chart.LineChart;
        import javafx.scene.chart.NumberAxis;
        import javafx.scene.chart.XYChart;
        import javafx.scene.control.*;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.layout.Pane;
        import javafx.scene.paint.Color;

        import java.net.URL;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.ResourceBundle;

public class Controller extends CF implements Initializable {
    @FXML private  TableView<CF> table;
    @FXML private  TableView<contest> contestTable;
    @FXML private TableColumn<CF,String> handle;
    @FXML private TableColumn<CF,String> rank;
    @FXML private TableColumn<CF,String> rating;
    @FXML private TableColumn<contest,String> contestName;
    @FXML private TableColumn<contest,Date> contestStartTime;
    @FXML private TableColumn<contest,String> contestDuration;
    @FXML private Label nameLabel,nLabel;
    @FXML private Label rankLabel,rLabel;
    @FXML private Label ratingLabel,rateLabel;
    @FXML private Label organizationLabel,orgLabel;
    @FXML private Label cRatingLabel,contestRatingLabel;
    @FXML private Label currentRankLabel,cRankLabel;
    @FXML private Label onlineLabel,onlineStatusLabel;
    @FXML private Label friendsLabel,frndLabel;
    @FXML private Label contributionLabel,contributeLabel;
    @FXML private Label profile;
    @FXML private Label billboard;
    @FXML private ImageView photo;
    @FXML private ImageView cf;
    @FXML private ImageView irank;
    @FXML private Button addButton;
    @FXML private Button deleteButton;
    @FXML private Button clearButton;
    @FXML private TextField handleInput;
    @FXML private AnchorPane anchor;
    @FXML private ImageView add;
    @FXML private ImageView delete;
    @FXML private Pane profilePane;
    @FXML private TabPane profileTabPane;
    @FXML private LineChart<String, Number> rankChart;
    @FXML private CategoryAxis x;
    @FXML private NumberAxis y;


    public ObservableList<CF> getCoders() throws Exception{

        ObservableList<CF> coders = FXCollections.observableArrayList();
        coders.add(new CF("Rashid_Abrar_Riyad"));
        coders.add(new CF("Nasib_Sultan"));
        coders.add(new CF("partha_mbstu"));
        coders.add(new CF("shovonshovo"));
        coders.add(new CF("nfssdq"));
        coders.add(new CF("frankenstein"));
        coders.add(new CF("asad_shuvo"));
        coders.add(new CF("inception_h"));
        coders.add(new CF("nazmul_49"));
        coders.add(new CF("demons_29"));
        coders.add(new CF("__P_K_B__"));

        return coders;

    }



    public void addButtonClicked() throws Exception {
        CF cf = new CF(handleInput.getText());
        table.getItems().add(cf);
        handleInput.clear();

    }

    public void ClearButtonClicked(){
                rankChart.getData().clear();

    }

    public void allClear(boolean b){
        isVisible(b);
        photo.setVisible(b);
        nameLabel.setVisible(b);
        rankLabel.setVisible(b);
        ratingLabel.setVisible(b);
        organizationLabel.setVisible(b);
        contestRatingLabel.setVisible(b);
    }
    public void anchorClicked()throws Exception{
        // profilePane.setVisible(false);
        //isVisible(false);
        //photo.setVisible(false);
        //nameLabel.setVisible(false);
        //rankLabel.setVisible(false;
        //ratingLabel.setVisible(false);
        //organizationLabel.setVisible(false);
    }

    public void deleteButtonClicked() throws Exception{
        ObservableList<CF> coderSelected,allCoder;
        allCoder = table.getItems();
        coderSelected = table.getSelectionModel().getSelectedItems();
        coderSelected.forEach(allCoder::remove);
        allClear(false);
        clickDetails();
    }

    public void rankColor(CF selected,String rank){
        if(selected.maxRank.equals("newbie"))
            rankLabel.setTextFill(Color.GRAY);
        else if(selected.maxRank.equals("pupil"))
            rankLabel.setTextFill(Color.GREEN);
        else if(selected.maxRank.equals("specialist"))
            rankLabel.setTextFill(Color.web("03A8AB"));
        else if(selected.maxRank.equals("expert"))
            rankLabel.setTextFill(Color.BLUE);
        else if(selected.maxRank.equals("candidate master"))
            rankLabel.setTextFill(Color.VIOLET);
        else if(selected.maxRank.equals("master"))
            rankLabel.setTextFill(Color.ORANGE);
        else if(selected.maxRank.equals("international master"))
            rankLabel.setTextFill(Color.ORANGE);
        else if(selected.maxRank.equals("grandmaster"))
            rankLabel.setTextFill(Color.RED);
        else if(selected.maxRank.equals("international grandmaster"))
            rankLabel.setTextFill(Color.RED);
        else if(selected.maxRank.equals("legendary grandmaster"))
            rankLabel.setTextFill(Color.RED);
    }

    public void currentRankColor(CF selected, String rank){
        if(selected.rank.equals("newbie"))
            currentRankLabel.setTextFill(Color.GRAY);
        else if(selected.rank.equals("pupil"))
            currentRankLabel.setTextFill(Color.GREEN);
        else if(selected.rank.equals("specialist"))
            currentRankLabel.setTextFill(Color.web("03A8AB"));
        else if(selected.rank.equals("expert"))
            currentRankLabel.setTextFill(Color.BLUE);
        else if(selected.rank.equals("candidate master"))
            currentRankLabel.setTextFill(Color.VIOLET);
        else if(selected.rank.equals("master"))
            currentRankLabel.setTextFill(Color.ORANGE);
        else if(selected.rank.equals("international master"))
            currentRankLabel.setTextFill(Color.ORANGE);
        else if(selected.rank.equals("grandmaster"))
            currentRankLabel.setTextFill(Color.RED);
        else if(selected.rank.equals("international grandmaster"))
            currentRankLabel.setTextFill(Color.RED);
        else if(selected.rank.equals("legendary grandmaster"))
            currentRankLabel.setTextFill(Color.RED);
    }
    public void clickDetails() throws Exception {
        allClear(true);
        profileTabPane.setVisible(true);
        profilePane.setVisible(true);
        billboard.setVisible(false);
        //deleteButton.setDisable(false);
        delete.setDisable(false);
        // delete.setVisible(true);
        CF selected = table.getSelectionModel().getSelectedItem();

        rankColor(selected,selected.maxRank);
        currentRankColor(selected,selected.rank);


        photo.setImage(selected.getPhoto());
        nameLabel.setText(selected.name);
        rankLabel.setText(selected.maxRank);

        ratingLabel.setText(selected.maxRating.toString());
        organizationLabel.setText(selected.org);
        contestRatingLabel.setText(selected.rating.toString());
        currentRankLabel.setText(selected.rank);
        friendsLabel.setText(selected.friends.toString().concat(" users"));
        contributionLabel.setText(selected.contribution.toString());


        if(selected.onlineDays!=0) {
            onlineStatusLabel.setText(String.valueOf(selected.onlineDays).concat(" Day(s) ago"));
        }

        else if(selected.onlineDays==0 && selected.onlineHours!=0)
            onlineStatusLabel.setText(String.valueOf(selected.onlineHours).concat(" Hour(s) ago"));
        else if(selected.onlineDays==0 && selected.onlineHours==0 && selected.onlineMinutes>15)
            onlineStatusLabel.setText(String.valueOf(selected.onlineMinutes).concat(" Minute(s) ago"));
        else if(selected.onlineMinutes<=15)
            onlineStatusLabel.setText("Online");


        rankGraph(selected.handle);


        isVisible(true);

    }

    public void isVisible(boolean b){
//        nLabel.setVisible(b);
        rLabel.setVisible(b);
        rateLabel.setVisible(b);
//        orgLabel.setVisible(b);
       // profile.setVisible(b);
        cRatingLabel.setVisible(b);
        irank.setVisible(b);
        onlineLabel.setVisible(b);
        frndLabel.setVisible(b);
        contributeLabel.setVisible(b);

    }

    /*********************************************************/

    //contest table
/*
    public ObservableList<CF> getContest() throws Exception{
        ObservableList<CF> contests = FXCollections.observableArrayList();
        contests.add(new CF(false));
       // contests.add(new CF(true));
        return contests;
    }
*/

//Rank Graph

    private void rankGraph(String handle) throws Exception {
        CF cf = new CF();
       ArrayList<Long> rankList= cf.getRankGraph(handle);
       ArrayList<Long> contestList= cf.getContestID();
       //ArrayList<String> nameList= cf.getRankGraph(handle);
        XYChart.Series<String,Number> series = new XYChart.Series();
       //System.out.println(rankList.size());

        int x=1;
        for(int i=0; i<rankList.size(); i++,x+=10){
            series.getData().add(new XYChart.Data<String,Number>(Long.toString(contestList.get(i)),rankList.get(i)));
        }
        rankChart.getData().addAll(series);
        series.setName(handle);
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        profileTabPane.setVisible(false);
        profilePane.setVisible(false);
        billboard.setVisible(true);
        // deleteButton.setDisable(true);
        delete.setDisable(true);
        //  delete.setVisible(false);
        isVisible(false);
       // contestTable.setVisible(false);



        contestName.setCellValueFactory(new PropertyValueFactory<contest,String>("contestName"));
        contestStartTime.setCellValueFactory(new PropertyValueFactory<contest,Date>("contestStartTime"));
        contestDuration.setCellValueFactory(new PropertyValueFactory<contest,String>("contestDuration"));


        try {
            CF contest = new CF();

            contestTable.setItems(contest.getContestInfo(false));
        } catch (Exception e) {
            e.printStackTrace();
        }

        handle.setCellValueFactory(new PropertyValueFactory<CF,String>("handle"));
        rank.setCellValueFactory(new PropertyValueFactory<CF,String>("rank"));
        rating.setCellValueFactory(new PropertyValueFactory<CF,String>("rating"));

        try {
            table.setItems(getCoders());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
