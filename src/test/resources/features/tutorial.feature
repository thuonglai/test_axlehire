Feature: Profile Tab./ Tutorials

  Scenario Outline: Profile Tab./ Tutorials
    Given Login to app
    And Clear tutorial
    When Create tutorial with type = <type>
    Then Create successful with message : Tutorial is successfully created
    And Check text in screen Active Assignment Title = <title>, Desc = <description>
    When Create tutorial with same type
    Then Create failed with message: A tutorial has previously been created in Active Assignment Tab

    Examples:
      | type           | title                           | description                                                                                                |
      | Assigned Route | Tutorial: Driving with AxleHire | Learn about the pick-up and drop-off process once a route has been assigned to you.                        |
      | Direct Booking | Tutorial: Direct Booking        | Learn about the process for selecting and delivering a route in areas where we allow direct route booking. |
      | Ticket Booking | Tutorial: Ticket Booking        | Learn about the process for selecting and delivering a route in areas where we have ticket booking         |